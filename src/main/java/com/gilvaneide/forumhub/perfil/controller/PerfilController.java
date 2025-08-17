package com.gilvaneide.forumhub.perfil.controller;

import com.gilvaneide.forumhub.perfil.repository.PerfilRepository;
import com.gilvaneide.forumhub.perfil.dto.DadosCadastroPerfil;
import com.gilvaneide.forumhub.perfil.dto.DadosListagemPerfil;
import com.gilvaneide.forumhub.perfil.entity.Perfil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/perfis")
@SecurityRequirement(name = "bearer-key")
public class PerfilController {

    private final PerfilRepository repository;

    public PerfilController(PerfilRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemPerfil> cadastrar(@RequestBody @Valid DadosCadastroPerfil dados, UriComponentsBuilder uriBuilder) {
        var perfil = new Perfil(null, dados.nome());
        repository.save(perfil);

        var uri = uriBuilder.path("/perfis/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemPerfil(perfil));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPerfil>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemPerfil::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}