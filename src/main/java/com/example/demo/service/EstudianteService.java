package com.example.demo.service;

import com.example.demo.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private com.example.demo.repository.EstudianteRepository EstudianteRepository;

    public List<Estudiante> findAll() {
        return EstudianteRepository.findAll();
    }

    public Optional<Estudiante> findById(int id) {
        return EstudianteRepository.findById(id);
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return EstudianteRepository.save(estudiante);
    }

    public Estudiante actualizarEstudiante(int id, Estudiante estudiante) {
        Estudiante actualizarEstudiante = EstudianteRepository.findById(id).orElse(null);
        actualizarEstudiante.setName(estudiante.getName());
        actualizarEstudiante.setMatricula(estudiante.getMatricula());
        actualizarEstudiante.setTelefono(estudiante.getTelefono());
        return EstudianteRepository.save(actualizarEstudiante);
    }

    public void EliminarID(int id) {
        EstudianteRepository.deleteById(id);
    }

}