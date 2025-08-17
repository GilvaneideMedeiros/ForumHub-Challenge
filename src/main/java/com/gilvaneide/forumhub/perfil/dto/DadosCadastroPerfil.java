package com.gilvaneide.forumhub.perfil.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPerfil(
        @NotBlank String nome
) {}