/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Proyecto;

/**
 *
 * @author tadeo
 */
public interface IProyectoService {
    public List<Proyecto> getProyectos();
    public void saveProyecto(Proyecto proy);
    public void deleteProyecto(Long id);
    public Proyecto findProyecto(Long id);
    public List<Proyecto> findProyectos(Long id);
    public void deleteAllByUsuario(Long id);
}

