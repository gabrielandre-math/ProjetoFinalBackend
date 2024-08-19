package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.domain.dtos.ComandaDTO;
import com.gabriel.smarorder.services.ComandaService;
import com.gabriel.smarorder.domain.models.Comanda;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ComandaDTO>> findAll() {
        List<Comanda> list = comandaService.findAll();
        List<ComandaDTO> listDTO = list.stream().map(ComandaDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ComandaDTO> create(@Valid @RequestBody ComandaDTO comandaDTO) {
        Comanda obj = comandaService.create(comandaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ComandaDTO> update(@PathVariable Integer id, @Valid @RequestBody ComandaDTO comandaDTO) {
        Comanda newObj = comandaService.update(id, comandaDTO);
        return ResponseEntity.ok().body(new ComandaDTO(newObj));
    }
}
