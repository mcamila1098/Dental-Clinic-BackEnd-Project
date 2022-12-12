package com.dentalclinicspring.appointmentbooking.controller;

import com.dentalclinicspring.appointmentbooking.dao.impl.PacienteDAOH2;
import com.dentalclinicspring.appointmentbooking.entity.Paciente;
import com.dentalclinicspring.appointmentbooking.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService = new PacienteService(new PacienteDAOH2());
    // GET MAPPING
    @GetMapping("/{pacienteId}")
    public Paciente buscarPacienteHandler(@PathVariable("pacienteId") Integer id){
        return pacienteService.listarPaciente(id);
    }

    // POST MAPPING
    @PostMapping("/crear")
    public Paciente registrarPacienteHandler(@RequestBody Paciente paciente){
        return pacienteService.agregarPaciente(paciente);
    }

    // PUT MAPPING
    @PutMapping("/actualizar")
    public ResponseEntity<Paciente> modificarPacienteHandler(@RequestBody Paciente paciente){
        ResponseEntity response = null;

        if(pacienteService.listarPaciente(paciente.getId()) ==null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(pacienteService.modificarPaciente(paciente),HttpStatus.OK);
        }
        return response;

    }

    // DELETE MAPPING
    @DeleteMapping("{pacienteId}")
    public ResponseEntity eliminarPacienteHandler(@PathVariable Integer id){
        ResponseEntity response = null;

        if(pacienteService.listarPaciente(id) ==null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else {
            pacienteService.eliminarPaciente(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
}
