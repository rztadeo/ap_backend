/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Skill;

/**
 *
 * @author tadeo
 */
public interface ISkillService {
    public List<Skill> getSkills();
    public void saveSkill(Skill skill);
    public void deleteSkill(Long id);
    public Skill findSkill(Long id);
    public List<Skill> findSkills(Long id);
    public void deleteAllByUsuario(Long id);
}
