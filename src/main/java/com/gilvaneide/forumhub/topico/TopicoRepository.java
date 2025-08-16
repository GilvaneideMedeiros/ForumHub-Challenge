package com.gilvaneide.forumhub.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT t FROM Topico t JOIN FETCH t.curso")
    List<Topico> findAllWithCurso();
}
