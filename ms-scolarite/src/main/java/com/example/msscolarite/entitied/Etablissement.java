package com.example.msscolarite.entitied;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtablissement;
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "etablissement")
    private Collection<Etudiant> etudiants;
}
