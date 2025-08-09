package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.curso.DadosCursoDTO;
import br.com.alura.forum_hub.dto.curso.DadosListagemCursoDTO;
import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("cursos")
public class CursoController {


    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity cadastrarCurso(@RequestBody @Valid DadosCursoDTO dados, UriComponentsBuilder uriComponentsBuilder){

        Curso curso = cursoService.salvar(new Curso(dados));

        var uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosCursoDTO(curso));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCursoDTO>> listagemDeCursos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return ResponseEntity.ok(cursoService.listar(paginacao));

    }
}
