/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.controller;

import java.util.List;
import org.rztadeo.apbackend.model.Usuario;
import org.rztadeo.apbackend.service.IUsuarioService;
import org.rztadeo.apbackend.Encriptado;
import org.rztadeo.apbackend.model.Sesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tadeo
 */
@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService interUsuario;
    private final String url = "http://localhost:4200";

    @CrossOrigin(origins = url)
    @GetMapping(path = "/usuarios/traer")
    public List<Usuario> getUsuarios() {
        return interUsuario.getUsuarios();
    }

    @CrossOrigin(origins = url)
    @PostMapping("/usuarios/crear")
    public String crearUsuario(@RequestBody Usuario user) {
        try {
            interUsuario.saveUsuario(user);
            return "La usuario fue creada exitosamente";
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @DeleteMapping("/usuarios/borrar/{nombre}")
    public String borrarUsuario(@PathVariable String nombre) {
        try {
            List<Usuario> usuarios = interUsuario.findByNombre(nombre);
            if (!usuarios.isEmpty()) {
                interUsuario.deleteUsuario(usuarios.get(0).getId());
                return "El usuario fue eliminida exitosamente";
            } else {
                return "El usuario no existe";
            }
        } catch (Exception e) {
            return "Ha ocurrido un error";
        }
    }

    @CrossOrigin(origins = url)
    @PutMapping("/usuarios/editar/{id}")
    public Usuario editUsuario(
            @PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("contra") String nuevaContra) {
        Usuario user = interUsuario.findUsuario(id);
        user.setNombre(nuevoNombre);
        user.setContra(nuevaContra);

        interUsuario.saveUsuario(user);
        return user;
    }

    @CrossOrigin(origins = url)
    @GetMapping("/usuarios/buscar/{nombre}")
    public List<Usuario> buscarUsuario(@PathVariable String nombre) {
        List<Usuario> usuarios = interUsuario.findByNombre(nombre);
        return usuarios;
    }

    @CrossOrigin(origins = url)
    @PostMapping("/login")
    public Sesion login(@RequestBody Sesion sesion) {
        String clave = Encriptado.encriptar(sesion.getUsuario() + sesion.getClave());
        List<Usuario> usuarios = interUsuario.findByNombre(sesion.getUsuario());
        if (usuarios.isEmpty()) {
            sesion.setClave("");
        } else {
            Usuario usuario = usuarios.get(0);
            String miClave = Encriptado.encriptar(usuario.getNombre() + usuario.getContra());
            if (clave.equals(miClave)) {
                sesion.setClave(clave);
            } else {
                sesion.setClave("");
            }
        }
        return sesion;
    }

    @CrossOrigin(origins = url)
    @PostMapping("/claves/comparar")
    public Sesion buscarClave(@RequestBody Sesion sesion) {
        if (sesion.getClave() != null) {
            List<Usuario> usuarios = interUsuario.findByNombre(sesion.getUsuario());
            Usuario usuario = usuarios.get(0);
            String claveReal = Encriptado.encriptar(usuario.getNombre() + usuario.getContra());
            String nuevaClave = (claveReal.equals(sesion.getClave()) ? sesion.getUsuario() : "");
            sesion.setClave(nuevaClave);
        } else {
            sesion.setClave("");
        }
        return sesion;
    }

    @CrossOrigin(origins = url)
    @PostMapping("/claves/traer")
    public Sesion traerClave(@RequestBody Sesion sesion) {
        List<Usuario> usuarios = interUsuario.findByNombre(sesion.getUsuario());
        Usuario usuario = usuarios.get(0);
        String claveReal = Encriptado.encriptar(usuario.getNombre() + usuario.getContra());
        sesion.setClave(claveReal);
        return sesion;
    }
}
