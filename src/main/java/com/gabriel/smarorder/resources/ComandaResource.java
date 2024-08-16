package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.domain.dtos.ComandaDTO;
import com.gabriel.smarorder.services.ComandaService;
import com.gabriel.smarorder.domain.models.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comandas")
public class ComandaResource {
    @Autowired
    private ComandaService comandaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ComandaDTO> findById(@PathVariable Integer id) {
        Comanda obj = comandaService.findById(id);
        return ResponseEntity.ok().body(new ComandaDTO(obj));
    }
}
