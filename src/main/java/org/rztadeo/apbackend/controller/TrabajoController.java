/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.controller;

import java.util.List;
import org.rztadeo.apbackend.model.Trabajo;
import org.rztadeo.apbackend.service.ITrabajoService;
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
public class TrabajoController {

    @Autowired
    private ITrabajoService interTrabajo;
    private final String url = "http://localhost:4200";

    @CrossOrigin(origins = url)
    @GetMapping(path = "/trabajos/traer")
    public List<Trabajo> getTrabajos() {
        return interTrabajo.getTrabajos();
    }

    @CrossOrigin(origins = url)
    @PostMapping("/trabajos/crear")
    public String crearTrabajo(@RequestBody Trabajo trabajo) {
        try {
            interTrabajo.saveTrabajo(trabajo);
            return "La trabajo fue creada exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @DeleteMapping("/trabajos/borrar/{id}")
    public String borrarTrabajo(@PathVariable Long id) {
        try {
            interTrabajo.deleteTrabajo(id);
            return "La trabajo fue eliminida exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @PutMapping("/trabajos/editar/{id}")
    public Trabajo editTrabajo(
            @PathVariable Long id,
            @RequestParam("entidad") String nuevaEntidad,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("inicio") int nuevoInicio,
            @RequestParam("fin") int nuevoFin,
            @RequestParam("path") String nuevoPath) {
        Trabajo trabajo = interTrabajo.findTrabajo(id);
        trabajo.setEntidad(nuevaEntidad);
        trabajo.setNombre(nuevoNombre);
        trabajo.setInicio(nuevoInicio);
        trabajo.setFin(nuevoFin);
        trabajo.setPathImg(nuevoPath);

        interTrabajo.saveTrabajo(trabajo);
        return trabajo;
    }

    @CrossOrigin(origins = url)
    @GetMapping("/trabajos/buscar/{id}")
    public List<Trabajo> buscarTrabajos(@PathVariable Long id) {
        return interTrabajo.findTrabajos(id);
    }

}
