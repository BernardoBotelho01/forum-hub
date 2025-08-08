package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.DadosTopicosDTO;
import br.com.alura.forum_hub.dto.TopicosDTO;
import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.service.TopicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoService topicoService;

    public ResponseEntity cadastroTopico (@RequestBody @Valid DadosTopicosDTO dados){

        var topico = topicoService.salvarTopico(new Topico(dados));

        return ResponseEntity.ok().body(new TopicosDTO(topico));
    }
}
