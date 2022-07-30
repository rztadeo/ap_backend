/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

/**
 *
 * @author tadeo
 */

@Getter
@Setter
public class Perfil {
    private Long id;
    private List<Persona> personal;
    private List<Trabajo> trabajos;
    private List<Estudio> estudios;
    private List<Proyecto> proyectos;
    private List<Skill> skills;
}
