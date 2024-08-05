package com.gabriel.smarorder.domain.enums;

public enum Prioridade {
    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

    private Integer codigo;
    private String descricao;


    Prioridade(int i, String roleAdmin) {
        this.codigo = i;
        this.descricao = roleAdmin;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (Prioridade perfil : Prioridade.values()) {
            if (codigo.equals(perfil.getCodigo())) {
                return perfil;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida");
    }
}
