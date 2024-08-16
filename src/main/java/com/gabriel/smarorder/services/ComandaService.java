package com.gabriel.smarorder.services;

import java.util.List;
import java.util.Optional;
import com.gabriel.smarorder.repositories.ComandaRepository;
import com.gabriel.smarorder.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gabriel.smarorder.domain.models.Comanda;
@Service
public class ComandaService {
    @Autowired
    private ComandaRepository comandaRepository;

    public Comanda findById(Integer id) {
        Optional<Comanda> obj = comandaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
    }

    public List<Comanda> findAll() {
        return comandaRepository.findAll();
    }
}
