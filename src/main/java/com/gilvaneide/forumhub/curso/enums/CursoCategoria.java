package com.gilvaneide.forumhub.curso.enums;

public enum CursoCategoria {
    PROGRAMACAO("Programação"),
    BACK_END("Back-end"),
    FRONT_END("Front-end"),
    DATA_SCIENCE("Data Science");

    private final String descricao;

    CursoCategoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


    public static CursoCategoria fromDescricao(String texto) {
        for (CursoCategoria categoria : CursoCategoria.values()) {
            if (categoria.descricao.equalsIgnoreCase(texto)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + texto);
    }
}