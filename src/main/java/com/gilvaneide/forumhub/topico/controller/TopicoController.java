package com.gilvaneide.forumhub.topico.controller;

import com.gilvaneide.forumhub.curso.repository.CursoRepository;
import com.gilvaneide.forumhub.curso.entity.Curso;
import com.gilvaneide.forumhub.topico.dto.DadosAtualizacaoTopico;
import com.gilvaneide.forumhub.topico.dto.DadosCadastroTopico;
import com.gilvaneide.forumhub.topico.dto.DadosDetalhamentoTopico;
import com.gilvaneide.forumhub.topico.repository.TopicoRepository;
import com.gilvaneide.forumhub.topico.entity.Topico;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<DadosDetalhamentoTopico> criarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var nomeCurso = dados.curso().nome();
        var curso = cursoRepository.findByNomeIgnoreCase(nomeCurso)                .orElseGet(() -> cursoRepository.save(new Curso(dados.curso())));

        var topico = new Topico(dados, curso);
        topicoRepository.save(topico);

        var dto = new DadosDetalhamentoTopico(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTopico>> listarTopicos() {
        var topicos = topicoRepository.findAllWithCurso();
        var dtoList = topicos.stream().map(DadosDetalhamentoTopico::new).toList();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalharTopico(@PathVariable Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Tópico não encontrado com id: " + id));
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizarTopico(@PathVariable Long id,
                                                                   @RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Tópico não encontrado para atualização com id: " + id));
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirTopico(@PathVariable Long id) {        
        if (!topicoRepository.existsById(id)) {
            throw new jakarta.persistence.EntityNotFoundException("Tópico não encontrado para exclusão com id: " + id);
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
