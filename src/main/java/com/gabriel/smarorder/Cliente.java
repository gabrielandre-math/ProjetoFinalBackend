package com.gabriel.smarorder;

import com.gabriel.smarorder.domain.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Cliente extends Pessoa {
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "cliente")
    private List<Comanda> comandas = new ArrayList<Comanda>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha, String telefone, List<Comanda> comandas) {
        super(id, nome, cpf, email, senha, telefone);
        this.comandas = comandas;
        addPerfil(Perfil.CLIENTE);
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}
