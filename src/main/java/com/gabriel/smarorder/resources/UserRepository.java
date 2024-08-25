package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.domain.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByEmail(String email);
}