/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.controller;

import java.util.List;
import org.rztadeo.apbackend.model.Proyecto;
import org.rztadeo.apbackend.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tadeo
 */
@RestController
public class ProyectoController {

    @Autowired
    private IProyectoService interProyecto;
    private final String url = "https://argentina-programa-310722.web.app";

    @CrossOrigin(origins = url)
    @GetMapping(path = "/proyectos/traer")
    public List<Proyecto> getProyectos() {
        return interProyecto.getProyectos();
    }

    @CrossOrigin(origins = url)
    @PostMapping("/proyectos/crear")
    public String crearProyecto(@RequestBody Proyecto proyecto) {
        try {
            interProyecto.saveProyecto(proyecto);
            return "La proyecto fue creada exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @DeleteMapping("/proyectos/borrar/{id}")
    public String borrarProyecto(@PathVariable Long id) {
        try {
            interProyecto.deleteProyecto(id);
            return "La proyecto fue eliminida exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @PutMapping("/proyectos/editar/{id}")
    public Proyecto editProyecto(
            @PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("repositorio") String nuevoRepo,
            @RequestParam("rol") String nuevoRol) {
        Proyecto proyecto = interProyecto.findProyecto(id);
        proyecto.setNombre(nuevoNombre);
        proyecto.setRepositorio(nuevoRepo);
        proyecto.setRol(nuevoRol);

        interProyecto.saveProyecto(proyecto);
        return proyecto;
    }
    
    @CrossOrigin(origins = url)
    @GetMapping("/proyectos/buscar/{id}")
    public List<Proyecto> buscarProyectos(@PathVariable Long id){
        return interProyecto.findProyectos(id);
    }
}
