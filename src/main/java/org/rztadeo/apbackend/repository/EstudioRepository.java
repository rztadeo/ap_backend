/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.rztadeo.apbackend.repository;

import java.util.List;
import org.rztadeo.apbackend.model.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;  

/**
 *
 * @author tadeo
 */

@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Long> {
    List<Estudio> findByUsuario(Long id);
}
