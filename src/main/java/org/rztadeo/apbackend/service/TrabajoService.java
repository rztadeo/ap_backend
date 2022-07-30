/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Trabajo;
import org.rztadeo.apbackend.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tadeo
 */
@Service
public class TrabajoService implements ITrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepo;

    @Override
    public List<Trabajo> getTrabajos() {
        List<Trabajo> listaTrabajos = trabajoRepo.findAll();
        return listaTrabajos;
    }

    @Override
    public void saveTrabajo(Trabajo trabajo) {
        trabajoRepo.save(trabajo);
    }

    @Override
    public void deleteTrabajo(Long id) {
        trabajoRepo.deleteById(id);
    }

    @Override
    public Trabajo findTrabajo(Long id) {
        Trabajo trabajo = trabajoRepo.findById(id).orElse(null);
        return trabajo;
    }

    @Override
    public List<Trabajo> findTrabajos(Long id) {
        List<Trabajo> trabajos = trabajoRepo.findByUsuario(id);
        return trabajos;
    }

    @Override
    public void deleteAllByUsuario(Long id) {
        List<Trabajo> trabajos = trabajoRepo.findByUsuario(id);
        for (Trabajo trabajo : trabajos) {
            trabajoRepo.deleteById(trabajo.getId());
        }
    }
}
