package com.gabriel.smarorder.domain.enums;

public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), FUNCIONARIO(2, "ROLE_FUNCIONARIO");

    private Integer codigo;
    private String descricao;


    Perfil(int i, String roleAdmin) {
        this.codigo = i;
        this.descricao = roleAdmin;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (Perfil perfil : Perfil.values()) {
            if (codigo.equals(perfil.getCodigo())) {
                return perfil;
            }
        }
        throw new IllegalArgumentException("Perfil inválido");
    }
}
