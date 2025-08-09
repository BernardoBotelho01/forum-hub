package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.perfil.DadosPerfilDTO;
import br.com.alura.forum_hub.dto.perfil.PerfilDTO;
import br.com.alura.forum_hub.model.Perfil;
import br.com.alura.forum_hub.service.PerfilService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("perfis")
public class PerfilController {

    private final PerfilService perfilService;

    @PostMapping
    public ResponseEntity cadastrarPerfil(@RequestBody @Valid DadosPerfilDTO dados, UriComponentsBuilder uriComponentsBuilder){

        Perfil perfil = perfilService.salvar(new Perfil(dados));
        var uri = uriComponentsBuilder.path("/perfis/{id}").buildAndExpand(perfil.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosPerfilDTO(perfil));

    }
}
