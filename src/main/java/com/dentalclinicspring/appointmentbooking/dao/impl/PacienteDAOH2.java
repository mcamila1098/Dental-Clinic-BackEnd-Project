package com.dentalclinicspring.appointmentbooking.dao.impl;

import com.dentalclinicspring.appointmentbooking.dao.IDaoPaciente;
import com.dentalclinicspring.appointmentbooking.entity.Paciente;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class PacienteDAOH2 implements IDaoPaciente<Paciente> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private  final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    private static final Logger LOGGER = Logger.getLogger(PacienteDAOH2.class);

    @Override
    public Paciente agregar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Conexión
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            connection.setAutoCommit(false);

            // Sentencia para insertar
            preparedStatement = connection.prepareStatement("INSERT INTO PACIENTES(NOMBRE,APELLIDO,DOMICILIO,DNI,FECHADEALTA) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setString(3,paciente.getDomicilio());
            preparedStatement.setString(4,paciente.getDNI());
            preparedStatement.setString(5,paciente.getFechaDeAlta());

            // Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            connection.setAutoCommit(true);

            LOGGER.debug("Se agregó un paciente");

        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("Error al insertar un paciente");
        }

        return paciente;
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
            preparedStatement = connection.prepareStatement("DELETE FROM PACIENTES WHERE ID=?");
            preparedStatement.setLong(1,id);

            // Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            connection.setAutoCommit(true);

            LOGGER.debug("Se eliminó un paciente");

        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("Error al eliminar un paciente");
        }
    }

    @Override
    public Paciente listar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;
        try {
            // Conexión
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            connection.setAutoCommit(false);

            // Sentencia para seleccionar por id
            preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID=?");
            preparedStatement.setLong(1,id);

            // Ejecutar la sentencia
            ResultSet result = preparedStatement.executeQuery();

            // Mostrar los resultados
            while (result.next()){
                System.out.println("ID:"+result.getLong(1)
                        +"\nNombre:"+ result.getString(2)
                        +"\nApellido:"+ result.getString(3)
                        +"\nDomicilio:"+ result.getString(4)
                        +"\nMatrícula:"+ result.getLong(5)
                        +"\nFecha de alta:"+ result.getString(6)
                );
            }
            connection.commit();
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("Error al listar un paciente");
        }

        return paciente;
    }
}
