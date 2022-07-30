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
@Table(name = "estudios")
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "entidad", nullable = false)
    private String entidad;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "inicio", nullable = false)
    private int inicio;
    
    @Column(name = "fin")
    private int fin;
    
    @Column(name = "img")
    private String pathImg;

    @Column(name = "usuario_id", nullable = false)
    private Long usuario;

}
