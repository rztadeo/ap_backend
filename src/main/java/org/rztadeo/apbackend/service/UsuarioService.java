/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Usuario;
import org.rztadeo.apbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tadeo
 */
@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        return listaUsuarios;
    }
    
    @Override
    public void saveUsuario(Usuario user){
        usuarioRepo.save(user);
    }
    
    @Override
    public void deleteUsuario(Long id){
        usuarioRepo.deleteById(id);
    }
    
    @Override
    public Usuario findUsuario(Long id){
        Usuario user = usuarioRepo.findById(id).orElse(null);
        return user;
    }
    
    @Override
    public List<Usuario> findByNombre(String nombre){
        List<Usuario> usuarios = usuarioRepo.findByNombre(nombre);
        return usuarios;
    }
}
