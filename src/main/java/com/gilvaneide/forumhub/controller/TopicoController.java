package com.gilvaneide.forumhub.controller;

import com.gilvaneide.forumhub.curso.Curso;
import com.gilvaneide.forumhub.curso.CursoRepository;
import com.gilvaneide.forumhub.topico.DadosCadastroTopico;
import com.gilvaneide.forumhub.topico.Topico;
import com.gilvaneide.forumhub.topico.TopicoRepository;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> criarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var nomeCurso = dados.curso().nome();
        var curso = cursoRepository.findByNomeIgnoreCase(nomeCurso)
                .orElseGet(() -> new Curso(dados.curso()));

        var topico = new Topico(dados, curso);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(null);
    }
}
