/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.model;

import java.util.Set;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author tadeo
 */

@Getter @Setter
@Entity
@Table(name = "usuarios")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    @Column(name="usuario")
    private String nombre;
    
    @Column(name="contrasena")
    private String contra;
}
