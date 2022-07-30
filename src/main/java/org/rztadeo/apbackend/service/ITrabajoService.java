/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Trabajo;

/**
 *
 * @author tadeo
 */
public interface ITrabajoService {
    public List<Trabajo> getTrabajos();
    public void saveTrabajo(Trabajo trabajo);
    public void deleteTrabajo(Long id);
    public Trabajo findTrabajo(Long id);
    public List<Trabajo> findTrabajos(Long id);
    public void deleteAllByUsuario(Long id);
}
