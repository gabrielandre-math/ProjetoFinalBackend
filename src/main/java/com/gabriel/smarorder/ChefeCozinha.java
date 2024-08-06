package com.gabriel.smarorder;

import com.gabriel.smarorder.domain.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ChefeCozinha extends Pessoa {
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "chefeCozinha")
    private List<Comanda> comandas = new ArrayList<Comanda>();

    public ChefeCozinha() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public ChefeCozinha(Integer id, String nome, String cpf, String email, String senha, String telefone) {
        super(id, nome, cpf, email, senha, telefone);
        addPerfil(Perfil.CLIENTE);
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}
