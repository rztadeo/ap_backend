/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.controller;

import java.util.List;
import org.rztadeo.apbackend.model.Skill;
import org.rztadeo.apbackend.service.ISkillService;
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
public class SkillController {

    @Autowired
    private ISkillService interSkill;
    private final String url = "http://localhost:4200";

    @CrossOrigin(origins = url)
    @GetMapping(path = "/skills/traer")
    public List<Skill> getSkills() {
        return interSkill.getSkills();
    }

    @CrossOrigin(origins = url)
    @PostMapping("/skills/crear")
    public String crearSkill(@RequestBody Skill skill) {
        try {
            interSkill.saveSkill(skill);
            return "La skill fue creada exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @DeleteMapping("/skills/borrar/{id}")
    public String borrarSkill(@PathVariable Long id) {
        try {
            interSkill.deleteSkill(id);
            return "La skill fue eliminida exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @PutMapping("/skills/editar/{id}")
    public Skill editSkill(
            @PathVariable Long id,
            @RequestParam("categoria") String nuevaCategoria,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("nivel") int nuevoNivel) {
        Skill skill = interSkill.findSkill(id);
        skill.setCategoria(nuevaCategoria); 
        skill.setNombre(nuevoNombre);
        skill.setNivel(nuevoNivel);

        interSkill.saveSkill(skill);
        return skill;
    }
    
    @CrossOrigin(origins = url)
    @GetMapping("/skills/buscar/{id}")
    public List<Skill> buscarSkill(@PathVariable Long id){
        return interSkill.findSkills(id);
    }
}