/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rztadeo.apbackend.service;

import java.util.List;
import org.rztadeo.apbackend.model.Skill;
import org.rztadeo.apbackend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tadeo
 */
@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository skillRepo;

    @Override
    public List<Skill> getSkills() {
        List<Skill> listaSkills = skillRepo.findAll();
        return listaSkills;
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = skillRepo.findById(id).orElse(null);
        return skill;
    }

    @Override
    public List<Skill> findSkills(Long id) {
        List<Skill> skills = skillRepo.findByUsuario(id);
        return skills;
    }

    @Override
    public void deleteAllByUsuario(Long id) {
        List<Skill> skills = skillRepo.findByUsuario(id);
        for (Skill skill : skills) {
            skillRepo.deleteById(skill.getId());
        }
    }
}
