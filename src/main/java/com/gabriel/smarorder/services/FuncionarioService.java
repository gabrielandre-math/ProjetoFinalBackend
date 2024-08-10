package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.models.Garcom;
import com.gabriel.smarorder.repositories.GarcomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GarcomService {
    @Autowired
    private GarcomRepository garcomRepository;

    public Garcom findById(Integer id) {
        Optional<Garcom> obj = garcomRepository.findById(id);
        return (Garcom) ((Optional<?>) obj).orElse(null);
    }
}
