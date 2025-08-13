package com.gilvaneide.forumHub.topico;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<TipoDaEntidade, TipoDoId>
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
