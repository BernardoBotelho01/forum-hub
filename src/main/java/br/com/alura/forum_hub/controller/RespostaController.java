package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.resposta.DadosListagemRespostaDTO;
import br.com.alura.forum_hub.dto.resposta.DadosRespostaDTO;
import br.com.alura.forum_hub.dto.resposta.RespostaDTO;
import br.com.alura.forum_hub.service.RespostaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    private final RespostaService respostaService;

    @PostMapping
    public ResponseEntity cadastrarResposta(@RequestBody @Valid DadosRespostaDTO dados,
                                                         UriComponentsBuilder uriBuilder) {
        var resposta = respostaService.salvar(dados); // <<< passa o DTO
        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new RespostaDTO(resposta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemRespostaDTO>> listagemDeRespostas(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return ResponseEntity.ok(respostaService.listar(paginacao));

    }
}

