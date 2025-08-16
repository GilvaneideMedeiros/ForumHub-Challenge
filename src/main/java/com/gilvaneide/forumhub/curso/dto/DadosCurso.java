package com.gilvaneide.forumhub.curso.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCurso(
    @NotBlank String nome,
    @NotBlank String categoria) {
}

