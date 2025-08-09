package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.resposta.DadosRespostaDTO;
import br.com.alura.forum_hub.dto.resposta.RespostaDTO;
import br.com.alura.forum_hub.model.Resposta;
import br.com.alura.forum_hub.service.RespostaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("respostas")
public class RespostaController {

    private final RespostaService respostaService;

    public ResponseEntity cadastarResposta(@RequestBody @Valid DadosRespostaDTO dados){
        var resposta = respostaService.salvar(new Resposta(dados));

        return ResponseEntity.ok().body(new RespostaDTO(resposta));
    }
}
