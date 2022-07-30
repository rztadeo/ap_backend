/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.controller;

import java.util.List;
import org.rztadeo.apbackend.model.Estudio;
import org.rztadeo.apbackend.model.Perfil;
import org.rztadeo.apbackend.model.Persona;
import org.rztadeo.apbackend.model.Proyecto;
import org.rztadeo.apbackend.model.Skill;
import org.rztadeo.apbackend.model.Trabajo;
import org.rztadeo.apbackend.model.Usuario;
import org.rztadeo.apbackend.service.IEstudioService;
import org.rztadeo.apbackend.service.IPersonaService;
import org.rztadeo.apbackend.service.IProyectoService;
import org.rztadeo.apbackend.service.ISkillService;
import org.rztadeo.apbackend.service.ITrabajoService;
import org.rztadeo.apbackend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tadeo
 */
@RestController
public class PerfilController {

    @Autowired
    private ITrabajoService interTrabajo;

    @Autowired
    private IProyectoService interProyecto;

    @Autowired
    private ISkillService interSkill;

    @Autowired
    private IEstudioService interEstudio;

    @Autowired
    private IPersonaService interPersona;

    @Autowired
    private IUsuarioService interUsuario;

    private final String url = "http://localhost:4200";

    @CrossOrigin(origins = url)
    @GetMapping(path = "/perfil/traer/{nombre}")
    public Perfil traerPerfil(@PathVariable String nombre) {
        Long id;
        Perfil perfil = new Perfil();
        List<Usuario> usuarios = interUsuario.findByNombre(nombre);
        System.out.println("por ACA");
        if (usuarios.isEmpty()) {
            id = (long) -1;
        } else {
            id = usuarios.get(0).getId();
        }
        perfil.setId(id);
        System.out.println(id);

        List<Estudio> estudios = interEstudio.findEstudios(id);
        List<Skill> skills = interSkill.findSkills(id);
        List<Proyecto> proyectos = interProyecto.findProyectos(id);
        List<Trabajo> trabajos = interTrabajo.findTrabajos(id);
        List<Persona> personas = interPersona.findByUsuario(id);

        perfil.setEstudios(estudios);
        perfil.setTrabajos(trabajos);
        perfil.setProyectos(proyectos);
        perfil.setSkills(skills);
        perfil.setPersonal(personas);

        return perfil;
    }

    @CrossOrigin(origins = url)
    @DeleteMapping("/perfil/borrar/{nombre}")
    public String borrarPerfil(@PathVariable String nombre) {
        try {
            List<Usuario> usuarios = interUsuario.findByNombre(nombre);
            if (!usuarios.isEmpty()) {
                try {
                    Long id = usuarios.get(0).getId();
                    interPersona.deleteAllByUsuario(id);
                    interProyecto.deleteAllByUsuario(id);
                    interEstudio.deleteAllByUsuario(id);
                    interTrabajo.deleteAllByUsuario(id);
                    interSkill.deleteAllByUsuario(id);
                    interUsuario.deleteUsuario(id);
                    return "El usuario fue eliminida exitosamente";
                } catch (Exception e) {
                    return "Ha ocurrido un error: "+e.getMessage();
                }
            } else {
                return "El usuario no existe";
            }
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }
}
