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
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "nivel")
    private int nivel;

    @Column(name = "usuario_id", nullable = false)
    private Long usuario;

}
