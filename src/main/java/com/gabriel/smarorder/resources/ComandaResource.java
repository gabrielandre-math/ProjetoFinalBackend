package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.domain.dtos.ComandaDTO;
import com.gabriel.smarorder.services.ComandaService;
import com.gabriel.smarorder.domain.models.Comanda;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/comandas")
public class ComandaResource {

    @Autowired
    private ComandaService comandaService;

    @PreAuthorize("hasAnyRole('ADMIN','FUNCIONARIO')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ComandaDTO> findById(@PathVariable Integer id) {
        Comanda obj = comandaService.findById(id);
        return ResponseEntity.ok().body(new ComandaDTO(obj));
    }

    @PreAuthorize("hasAnyRole('ADMIN','FUNCIONARIO')")
    @GetMapping
    public ResponseEntity<List<ComandaDTO>> findAll() {
        List<Comanda> list = comandaService.findAll();
        List<ComandaDTO> listDTO = list.stream().map(ComandaDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN','FUNCIONARIO')")
    @PostMapping
    public ResponseEntity<ComandaDTO> create(@Valid @RequestBody ComandaDTO comandaDTO) {
        Comanda obj = comandaService.create(comandaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN','FUNCIONARIO')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ComandaDTO> update(@PathVariable Integer id, @Valid @RequestBody ComandaDTO comandaDTO) {
        Comanda newObj = comandaService.update(id, comandaDTO);
        return ResponseEntity.ok().body(new ComandaDTO(newObj));
    }

    // Novo endpoint para polling de comandas atualizadas
    @PreAuthorize("hasAnyRole('ADMIN','FUNCIONARIO')")
    @GetMapping("/poll")
    public ResponseEntity<List<ComandaDTO>> getComandasAtualizadas(@RequestParam("lastUpdateTime") Optional<LocalDateTime> lastUpdateTime) {
        List<ComandaDTO> comandas = comandaService.findComandasAtualizadas(lastUpdateTime.orElse(LocalDateTime.MIN));
        return ResponseEntity.ok().body(comandas);
    }
}
