package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.curso.CursoDTO;
import br.com.alura.forum_hub.dto.curso.DadosCursoDTO;
import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("cursos")
public class CursoController {


    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity cadastrarCurso(@RequestBody @Valid DadosCursoDTO dados){
        var curso = cursoService.salvar(new Curso(dados));

        return ResponseEntity.ok().body(new CursoDTO(curso));
    }
}
