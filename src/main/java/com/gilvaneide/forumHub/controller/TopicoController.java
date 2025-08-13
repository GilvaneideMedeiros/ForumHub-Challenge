package com.gilvaneide.forumHub.controller;

import com.gilvaneide.forumHub.topico.DadosCadastroTopico;
import com.gilvaneide.forumHub.topico.Topico;
import com.gilvaneide.forumHub.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public void criarTopico(@RequestBody @Valid DadosCadastroTopico dados) {
        topicoRepository.save(new Topico(dados));

    }
}
