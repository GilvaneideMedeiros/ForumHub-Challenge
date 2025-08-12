package com.gilvaneide.forumHub.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosCurso(
    @NotBlank String nome) {

}
