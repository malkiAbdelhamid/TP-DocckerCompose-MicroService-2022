package com.example.msscolarite.Controller;

import com.example.msscolarite.Repositories.EtudiantRepository;
import com.example.msscolarite.entitied.Etudiant;
import com.example.msscolarite.proxy.FormationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ScolariteController {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    FormationProxy formationProxy;

    @GetMapping("etudiant/{id}/formation")
    Etudiant getETudiantWithFormation(@PathVariable("id") Long ide)    {
        Etudiant etudiant=etudiantRepository.findById(ide).get();
        etudiant.setFormation(formationProxy.getFormation(etudiant.getIdFormation()));
        return etudiant;
    }

    @GetMapping("etudiant/formation")
    List<Etudiant> getEtudins()
    {
        List<Etudiant> etudiants=etudiantRepository.findAll();

         etudiants.forEach((e)->{
             e.setFormation(formationProxy.getFormation(e.getIdFormation()));
         });

        return  etudiants;
    }
}
