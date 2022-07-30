/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Usuario;

/**
 *
 * @author tadeo
 */
public interface IUsuarioService {
    public List<Usuario> getUsuarios();
    public void saveUsuario(Usuario user);
    public void deleteUsuario(Long id);
    public Usuario findUsuario(Long id);
    public List<Usuario> findByNombre(String nombre);
}
