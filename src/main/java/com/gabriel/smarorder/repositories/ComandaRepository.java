package com.gabriel.smarorder.repositories;
import com.gabriel.smarorder.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComandaRepository extends JpaRepository<Comanda, Integer> {
    
}
