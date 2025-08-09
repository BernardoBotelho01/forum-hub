package br.com.alura.forum_hub.dto.resposta;

import br.com.alura.forum_hub.model.Resposta;
import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.model.Usuario;
import jakarta.validation.Valid;

import java.time.LocalDateTime;

public record RespostaDTO(
        String mensagem,
        Topico topico,
        LocalDateTime dataCriacao,
        Usuario autor,
        String solucao
) {

    public RespostaDTO(Resposta dados) {

        this(
                dados.getMensagem(),
                dados.getTopico(),
                dados.getDataCriacao(),
                dados.getAutor(),
                dados.getSolucao()
        );
    }
}
