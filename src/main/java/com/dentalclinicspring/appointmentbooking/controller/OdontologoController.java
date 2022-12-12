package com.dentalclinicspring.appointmentbooking.controller;

import com.dentalclinicspring.appointmentbooking.dto.OdontologoDTO;
import com.dentalclinicspring.appointmentbooking.entity.Odontologo;
import com.dentalclinicspring.appointmentbooking.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    //private final OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    // GET MAPPING
    /*@GetMapping("/buscar/{id}")
    public OdontologoDTO buscarOdontologo(@PathVariable Integer id){
        OdontologoDTO odontologo = odontologoService.listarOdontologo(id);
        return odontologo;
    }*/

    @GetMapping("/buscar/{id}")
    public Odontologo buscarOdontologo(@PathVariable Integer id){
        return  odontologoService.listarOdontologo(id);
    }

    // POST MAPPING
    @PostMapping("/crear")
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.agregarOdontologo(odontologo);
    }

    // PUT MAPPING

    // DELETE MAPPING

}
