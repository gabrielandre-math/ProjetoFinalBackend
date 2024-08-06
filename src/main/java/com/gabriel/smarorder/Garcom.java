package com.gabriel.smarorder;

import com.gabriel.smarorder.domain.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Garcom extends Pessoa {
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "garcom")
    private List<Comanda> comandas = new ArrayList<Comanda>();


    public Garcom() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Garcom(Integer id, String nome, String cpf, String email, String senha, String telefone) {
        super(id, nome, cpf, email, senha, telefone);
        addPerfil(Perfil.CLIENTE);
    }
}
