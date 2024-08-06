package com.gabriel.smarorder;

import java.util.ArrayList;
import java.util.List;

public class ChefeCozinha extends Pessoa {
    private List<Comanda> comandas = new ArrayList<Comanda>();

    public ChefeCozinha() {
        super();
    }

    public ChefeCozinha(Integer id, String nome, String cpf, String email, String senha, String telefone) {
        super(id, nome, cpf, email, senha, telefone);
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}
