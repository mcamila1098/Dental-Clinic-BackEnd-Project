package com.dentalclinicspring.appointmentbooking.service;


import com.dentalclinicspring.appointmentbooking.dao.IDaoPaciente;
import com.dentalclinicspring.appointmentbooking.entity.Paciente;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    private IDaoPaciente<Paciente> pacienteIDao;

    public PacienteService(IDaoPaciente<Paciente> pacienteIDao){this.pacienteIDao = pacienteIDao;}

    public Paciente agregarPaciente(Paciente p){return pacienteIDao.agregar(p);}
    public void eliminarPaciente(Long id){pacienteIDao.eliminar(id);}
    public Paciente listarPaciente(Long id){return pacienteIDao.listar(id);}
}
