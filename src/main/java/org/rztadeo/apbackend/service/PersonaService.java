/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Persona;
import org.rztadeo.apbackend.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tadeo
 */
@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepo;
    
    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = personaRepo.findAll();
        return listaPersonas;
    }
    
    @Override
    public void savePersona(Persona perso){
        personaRepo.save(perso);
    }
    
    @Override
    public void deletePersona(Long id){
        personaRepo.deleteById(id);
    }
    
    @Override
    public Persona findPersona(Long id){
        Persona perso = personaRepo.findById(id).orElse(null);
        return perso;
    }
    
    @Override
    public List<Persona> findByUsuario(Long id){
        List<Persona> personas = personaRepo.findByUsuario(id);
        return personas;
    }
    
    @Override 
        public void deleteAllByUsuario(Long id){
        List<Persona> personas = personaRepo.findByUsuario(id);
        for (Persona persona:personas){
        personaRepo.deleteById(persona.getId());
    }
    }
}
