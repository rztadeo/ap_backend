/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.controller;

import java.util.List;
import org.rztadeo.apbackend.model.Estudio;
import org.rztadeo.apbackend.model.Usuario;
import org.rztadeo.apbackend.service.IEstudioService;
import org.rztadeo.apbackend.service.IUsuarioService;
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
public class EstudioController {

    @Autowired
    private IEstudioService interEstudio;
    private final String url = "http://localhost:4200";

    @CrossOrigin(origins = url)
    @GetMapping(path = "/estudios/traer")
    public List<Estudio> getEstudios() {
        return interEstudio.getEstudios();
    }

    @CrossOrigin(origins = url)
    @PostMapping("/estudios/crear")
    public String crearEstudio(@RequestBody Estudio estudio) {
        try {
            interEstudio.saveEstudio(estudio);
            return "La estudio fue creada exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @DeleteMapping("/estudios/borrar/{id}")
    public String borrarEstudio(@PathVariable Long id) {
        try {
            interEstudio.deleteEstudio(id);
            return "La estudio fue eliminida exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @PutMapping("/estudios/editar/{id}")
    public Estudio editEstudio(@RequestBody Estudio nuevoEstudio) {
        Estudio estudio = interEstudio.findEstudio(nuevoEstudio.getId());
        estudio.setEntidad(nuevoEstudio.getEntidad());
        estudio.setNombre(nuevoEstudio.getNombre());
        estudio.setInicio(nuevoEstudio.getInicio());
        estudio.setFin(nuevoEstudio.getFin());
        
        interEstudio.saveEstudio(estudio);
        return estudio;
    }
    
    @CrossOrigin(origins = url)
    @GetMapping("/estudios/buscar/{id}")
    public List<Estudio> buscarEstudios(@PathVariable Long id){
        return interEstudio.findEstudios(id);
    }
}
