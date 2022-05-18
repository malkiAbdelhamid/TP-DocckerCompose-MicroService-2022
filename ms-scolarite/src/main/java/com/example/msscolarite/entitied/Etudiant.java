package com.example.msscolarite.entitied;

import com.example.msscolarite.model.Formation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateN;
    private String promo;
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @ManyToOne
    private Etablissement etablissement;
    private Long idFormation;

    @Transient
    private Formation formation;

}