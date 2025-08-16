package com.gilvaneide.forumhub.curso.entity;

import com.gilvaneide.forumhub.curso.enums.CursoCategoria;
import com.gilvaneide.forumhub.curso.dto.DadosCurso;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private CursoCategoria categoria;

    public Curso(DadosCurso dados) {
        this.nome = dados.nome();
        this.categoria = CursoCategoria.valueOf(dados.categoria().toUpperCase().replace("-", "_"));
    }
}
