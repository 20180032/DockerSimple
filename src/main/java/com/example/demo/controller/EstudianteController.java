package com.example.demo.controller;

import com.example.demo.model.Estudiante;
import com.example.demo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @RequestMapping("/lista-estudiante")
    public String mostrarEstudiante(Model model) {
        model.addAttribute("contacts", estudianteService.findAll());
        return "listaestudiante";
    }

    @RequestMapping("/agregar-estudiante")
    public String mostraragregarEstudiante(Model model) {
        model.addAttribute("command", new Estudiante());
        return "agregarestudiante";
    }

    @RequestMapping(value = "/agregar-estudiante", method = RequestMethod.POST)
    public String agregarEstudiante(@ModelAttribute("contact") Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/lista-estudiante";
    }

    @RequestMapping(value = "/actualizar-estudiante/{id}")
    public String mostraractualizarEstudiantes(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", estudianteService.findById(id).orElse(null));
        return "actualizarestudiante";
    }

    @RequestMapping(value = "/actualizar-estudiante/{id}", method = RequestMethod.POST)
    public String actualizarEstudiante(@PathVariable int id, @ModelAttribute("contact") Estudiante estudiante) {
        estudianteService.actualizarEstudiante(id, estudiante);
        return "redirect:/lista-estudiante";
    }

    @RequestMapping(value = "/borrar-estudiante/{id}")
    public String borrarEstudiante(@PathVariable int id) {
        estudianteService.EliminarID(id);
        return "redirect:/lista-estudiante";
    }

}