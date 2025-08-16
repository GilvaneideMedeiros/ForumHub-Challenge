package com.gilvaneide.forumhub.topico.dto;

import com.gilvaneide.forumhub.topico.enums.EstadoTopico;
import com.gilvaneide.forumhub.topico.entity.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        EstadoTopico estado,
        String nomeCurso) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(),
             topico.getTitulo(),
             topico.getMensagem(),
             topico.getDataCriacao(),
             topico.getAutor(),
             topico.getEstado(),
             topico.getCurso().getNome());
    }
}