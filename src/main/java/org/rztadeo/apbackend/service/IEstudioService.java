/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Estudio;

/**
 *
 * @author tadeo
 */
public interface IEstudioService {
    public List<Estudio> getEstudios();
    public void saveEstudio(Estudio estudio);
    public void deleteEstudio(Long id);
    public Estudio findEstudio(Long id);
    public List<Estudio> findEstudios(Long id);
    public void deleteAllByUsuario(Long id);
}
