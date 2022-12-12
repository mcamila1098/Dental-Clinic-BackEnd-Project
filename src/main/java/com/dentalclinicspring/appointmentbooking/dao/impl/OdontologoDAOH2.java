package com.dentalclinicspring.appointmentbooking.dao.impl;



import com.dentalclinicspring.appointmentbooking.dao.IDaoOdontologo;
import com.dentalclinicspring.appointmentbooking.entity.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class OdontologoDAOH2 implements IDaoOdontologo<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private  final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Conexión
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            connection.setAutoCommit(false);

            // Sentencia para insertar
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS VALUES(?,?,?,?)");
            preparedStatement.setLong(1,odontologo.getId());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.setLong(4,odontologo.getMatricula());

            // Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            connection.setAutoCommit(true);

            LOGGER.debug("Se agregó un odontologo");

        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("Error al insertar un odontologo");
        }

        return odontologo;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Conexión
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            connection.setAutoCommit(false);

            // Sentencia para eliminar
            preparedStatement = connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
            preparedStatement.setLong(1,id);

            // Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            connection.setAutoCommit(true);

            LOGGER.debug("Se eliminó un odontologo");

        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("Error al eliminar un odontologo");
        }
    }

    @Override
    public Odontologo listar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        try {
            // Conexión
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            connection.setAutoCommit(false);

            // Sentencia para seleccionar por id
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID=?");
            preparedStatement.setLong(1,id);

            // Ejecutar la sentencia
            ResultSet result = preparedStatement.executeQuery();

            // Mostrar los resultados
            while (result.next()){
                System.out.println("ID:"+result.getLong(1)
                        +"\nNombre:"+ result.getString(2)
                        +"\nApellido:"+ result.getString(3)
                        +"\nMatrícula:"+ result.getLong(4)
                );
            }
            connection.commit();
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("Error al listar un odontologo");
        }

        return odontologo;
    }

}
