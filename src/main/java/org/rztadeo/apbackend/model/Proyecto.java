/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author tadeo
 */
@Getter
@Setter
@Entity
@Table(name="proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="repositorio")
    private String repositorio;
    
    @Column(name="rol")
    private String rol;

    @Column(name = "usuario_id", nullable=false)
    private Long usuario;
}
