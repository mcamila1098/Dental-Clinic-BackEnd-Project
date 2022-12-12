package com.dentalclinicspring.appointmentbooking.service;

import com.dentalclinicspring.appointmentbooking.dao.IDaoOdontologo;
import com.dentalclinicspring.appointmentbooking.dto.OdontologoDTO;
import com.dentalclinicspring.appointmentbooking.entity.Odontologo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class OdontologoService {

    private IDaoOdontologo<Odontologo> odontologoIDao;

    public OdontologoService(IDaoOdontologo<Odontologo> odontologoIDao){this.odontologoIDao = odontologoIDao;}


    public Odontologo agregarOdontologo(Odontologo o){
        return odontologoIDao.agregar(o);
    }

    public void eliminarOdontologo(Integer id){
        odontologoIDao.eliminar(id);
    }

    /*public OdontologoDTO listarOdontologo(Integer id){
        ObjectMapper objectMapper = new ObjectMapper();
        Odontologo odontologo = odontologoIDao.listar(id);
        OdontologoDTO odontologoDTO;
        odontologoDTO = objectMapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }*/

    public Odontologo listarOdontologo(Integer id){return odontologoIDao.listar(id);}
    public Odontologo modificarOdontologo(Odontologo o){return odontologoIDao.modificar(o);}

}
