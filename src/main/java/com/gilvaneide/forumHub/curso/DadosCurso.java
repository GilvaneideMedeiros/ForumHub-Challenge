package com.gilvaneide.forumHub.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCurso(
    @NotBlank String nome) {

}
