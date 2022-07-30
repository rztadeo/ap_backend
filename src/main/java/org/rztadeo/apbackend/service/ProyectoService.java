/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Proyecto;
import org.rztadeo.apbackend.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tadeo
 */
@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyecRepo;

    @Override
    public List<Proyecto> getProyectos() {
        List<Proyecto> listaProyectos = proyecRepo.findAll();
        return listaProyectos;
    }
    
    @Override
    public void saveProyecto(Proyecto proyecto){
        proyecRepo.save(proyecto);
    }
    
    @Override
    public void deleteProyecto(Long id){
        proyecRepo.deleteById(id);
    }
    
    @Override
    public Proyecto findProyecto(Long id){
        Proyecto proyecto = proyecRepo.findById(id).orElse(null);
        return proyecto;
    }
    
    @Override
    public List<Proyecto> findProyectos(Long id){
        List<Proyecto> proyectos = proyecRepo.findByUsuario(id);
        return proyectos;
    }
    
        @Override 
        public void deleteAllByUsuario(Long id){
        List<Proyecto> proyectos = proyecRepo.findByUsuario(id);
        for (Proyecto proyecto:proyectos){
        proyecRepo.deleteById(proyecto.getId());
    }
        }
}
