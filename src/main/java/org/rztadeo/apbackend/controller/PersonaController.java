/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.controller;

import java.util.List;
import org.rztadeo.apbackend.model.Persona;
import org.rztadeo.apbackend.service.IPersonaService;
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
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;
    private final String url = "http://localhost:4200";

    @CrossOrigin(origins = url)
    @GetMapping(path = "/personas/traer")
    public List<Persona> getPersonas() {
        return interPersona.getPersonas();
    }

    @CrossOrigin(origins = url)
    @PostMapping("/personas/crear")
    public String crearPersona(@RequestBody Persona perso) {
        try {
            List<Persona> misPersonas = interPersona.getPersonas();
            if (misPersonas.isEmpty()){
            interPersona.savePersona(perso);
            } else {
                interPersona.deletePersona(misPersonas.get(0).getId());
                interPersona.savePersona(perso);
            }
            return "La persona fue creada exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error: "+e.getMessage();
        }
    }

    @CrossOrigin(origins = url)
    @DeleteMapping("/personas/borrar/{id}")
    public String borrarPersona(@PathVariable Long id) {
        try {
            interPersona.deletePersona(id);
            return "La persona fue eliminida exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(
            @PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("edad") int nuevaEdad,
            @RequestParam("bio") String nuevaBio) {
        Persona perso = interPersona.findPersona(id);
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setEdad(nuevaEdad);
        perso.setBio(nuevaBio);

        interPersona.savePersona(perso);
        return perso;
    }
    
    @CrossOrigin(origins = url)
    @GetMapping("/personas/buscar/{id}")
        public List<Persona> buscarPersona(@PathVariable Long id){
            List<Persona> personas = interPersona.findByUsuario(id);
            return personas;
        }

}
