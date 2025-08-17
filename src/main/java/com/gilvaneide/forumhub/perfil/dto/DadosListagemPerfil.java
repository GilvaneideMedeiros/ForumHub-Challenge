package com.gilvaneide.forumhub.perfil.dto;

import com.gilvaneide.forumhub.perfil.entity.Perfil;

public record DadosListagemPerfil(Long id, String nome) {
    public DadosListagemPerfil(Perfil perfil) {
        this(perfil.getId(), perfil.getAuthority());
    }
}