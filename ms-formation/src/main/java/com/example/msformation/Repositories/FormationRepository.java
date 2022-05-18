package com.example.msformation.Repositories;

import com.example.msformation.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository
        extends  JpaRepository<Formation,Long> {
}
