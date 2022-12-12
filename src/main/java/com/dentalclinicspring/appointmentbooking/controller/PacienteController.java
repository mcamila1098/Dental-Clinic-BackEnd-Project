package com.dentalclinicspring.appointmentbooking.controller;

import com.dentalclinicspring.appointmentbooking.dao.impl.PacienteDAOH2;
import com.dentalclinicspring.appointmentbooking.entity.Paciente;
import com.dentalclinicspring.appointmentbooking.service.PacienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService = new PacienteService(new PacienteDAOH2());
    // GET MAPPING

    // POST MAPPING
    @PostMapping()
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.agregarPaciente(paciente);
    }

    // PUT MAPPING

    // DELETE MAPPING
}
