package com.gabriel.smarorder.resources;

import com.gabriel.smarorder.domain.dtos.FuncionarioDTO;
import com.gabriel.smarorder.domain.models.Funcionario;
import com.gabriel.smarorder.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
