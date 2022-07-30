/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.model;

import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tadeo
 */
@Getter
@Setter
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name="nombre", nullable = false)
    private String nombre;
    
    @Column(name="apellido", nullable = false)
    private String apellido;
    
    @Column(name="edad")
    private int edad;
    
    @Column(name="bio")
    private String bio;

    @Column(name = "usuario_id", nullable = false)
    private Long usuario;
    
    @Column(name = "imagen_bg")
    private String imagenBg;
    
    @Column(name = "imagen_perfil")
    private String imagenPerfil;
}
