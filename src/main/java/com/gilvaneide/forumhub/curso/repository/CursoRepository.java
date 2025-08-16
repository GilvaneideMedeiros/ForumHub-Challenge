package com.gilvaneide.forumhub.curso.repository;

import com.gilvaneide.forumhub.curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNomeIgnoreCase(String nome);
}