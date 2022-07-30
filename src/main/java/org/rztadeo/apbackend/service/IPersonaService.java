/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Persona;

/**
 *
 * @author tadeo
 */
public interface IPersonaService {
    public List<Persona> getPersonas();
    public void savePersona(Persona perso);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
    public List<Persona> findByUsuario(Long id);
    public void deleteAllByUsuario(Long id);
}
