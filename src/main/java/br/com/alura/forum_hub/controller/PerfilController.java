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

@RestController
@RequiredArgsConstructor
@RequestMapping("perfis")
public class PerfilController {

    private final PerfilService perfilService;

    @PostMapping
    public ResponseEntity cadastrarPerfil(@RequestBody @Valid DadosPerfilDTO dados){
        var perfil = perfilService.salvar(new Perfil(dados));
        return ResponseEntity.ok().body(new PerfilDTO(perfil));
    }
}
