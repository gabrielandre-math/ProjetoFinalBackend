package com.gabriel.smarorder.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.smarorder.domain.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Funcionario extends Pessoa {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<Comanda> comandas = new ArrayList<Comanda>();


    public Funcionario() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Funcionario(Integer id, String nome, String cpf, String email, String senha, String telefone) {
        super(id, nome, cpf, email, senha, telefone);
        addPerfil(Perfil.FUNCIONARIO);
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}
