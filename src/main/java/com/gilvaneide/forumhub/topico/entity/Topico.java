package com.gilvaneide.forumhub.topico.entity;

import com.gilvaneide.forumhub.curso.entity.Curso;
import com.gilvaneide.forumhub.topico.dto.DadosAtualizacaoTopico;
import com.gilvaneide.forumhub.topico.dto.DadosCadastroTopico;
import com.gilvaneide.forumhub.topico.enums.EstadoTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private String autor;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "estado")
    private EstadoTopico estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(DadosCadastroTopico dados, Curso curso) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = curso;
        this.dataCriacao = LocalDateTime.now();
        this.estado = EstadoTopico.NAO_RESPONDIDO;
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.estado() != null) {
            this.estado = dados.estado();
        }
    }
}