package com.gabriel.smarorder.repositories;

import com.gabriel.smarorder.domain.models.Garcom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarcomRepository extends JpaRepository<Garcom, Integer> {
    
}
