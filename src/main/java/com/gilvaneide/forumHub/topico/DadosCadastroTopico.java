package com.gilvaneide.forumHub.topico;

import com.gilvaneide.forumHub.curso.DadosCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotNull
        @Valid
        DadosCurso curso) {

}

