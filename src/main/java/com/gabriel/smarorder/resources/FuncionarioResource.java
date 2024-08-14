package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.domain.dtos.FuncionarioDTO;
import com.gabriel.smarorder.domain.models.Funcionario;
import com.gabriel.smarorder.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Integer id) {
        Funcionario obj = funcionarioService.findById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }
    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> findAll() {
        List<Funcionario> list = funcionarioService.findAll();
        List<FuncionarioDTO> listDTO = list.stream().map(FuncionarioDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO objDTO) {
        Funcionario newObj = funcionarioService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(null).build();
    }
}
