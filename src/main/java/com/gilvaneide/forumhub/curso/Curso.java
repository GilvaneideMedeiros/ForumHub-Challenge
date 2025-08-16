package com.gilvaneide.forumhub.curso;

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
        this.categoria = CursoCategoria.valueOf(dados.categoria().toUpperCase());
    }
}
