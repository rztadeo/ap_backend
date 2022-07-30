/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Estudio;
import org.rztadeo.apbackend.repository.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tadeo
 */
@Service
public class EstudioService implements IEstudioService{

    @Autowired
    private EstudioRepository estudioRepo;
    
    @Override
    public List<Estudio> getEstudios() {
        List<Estudio> listaEstudios = estudioRepo.findAll();
        return listaEstudios;
    }
    
    @Override
    public void saveEstudio(Estudio estudio){
        estudioRepo.save(estudio);
    }
    
    @Override
    public void deleteEstudio(Long id){
        estudioRepo.deleteById(id);
    }
    
    @Override
    public Estudio findEstudio(Long id){
        Estudio estudio = estudioRepo.findById(id).orElse(null);
        return estudio;
    }
    
    @Override
    public List<Estudio> findEstudios(Long id){
        List<Estudio> estudios = estudioRepo.findByUsuario(id);
        return estudios;
    }
    
        @Override 
        public void deleteAllByUsuario(Long id){
        List<Estudio> estudios = estudioRepo.findByUsuario(id);
        for (Estudio estudio:estudios){
        estudioRepo.deleteById(estudio.getId());
        }
    }
}
