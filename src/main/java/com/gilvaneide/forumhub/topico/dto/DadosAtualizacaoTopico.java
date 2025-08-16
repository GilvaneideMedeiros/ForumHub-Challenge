package com.gilvaneide.forumhub.topico.dto;

import com.gilvaneide.forumhub.topico.enums.EstadoTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        EstadoTopico estado) {
}