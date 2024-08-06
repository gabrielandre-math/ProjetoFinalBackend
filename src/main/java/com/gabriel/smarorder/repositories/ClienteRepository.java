package com.gabriel.smarorder.repositories;

import com.gabriel.smarorder.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
