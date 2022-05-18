package com.example.msscolarite.Repositories;



import com.example.msscolarite.entitied.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findEtudiantByIdFormation(Long idf);

}
