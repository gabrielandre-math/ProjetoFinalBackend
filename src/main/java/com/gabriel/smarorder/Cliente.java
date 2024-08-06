package com.gabriel.smarorder;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private List<Comanda> comandas = new ArrayList<Comanda>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha, String telefone, List<Comanda> comandas) {
        super(id, nome, cpf, email, senha, telefone);
        this.comandas = comandas;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}
