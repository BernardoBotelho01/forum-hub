package br.com.alura.forum_hub.dto.resposta;

import br.com.alura.forum_hub.model.Resposta;

import java.time.LocalDateTime;

public record DadosListagemRespostaDTO(
        long id,
        String mensagem,
        String topico,
        LocalDateTime dataCriacao,
        String autor,
        String solucao
) {

    public DadosListagemRespostaDTO(Resposta dados) {

        this(
                dados.getId(),
                dados.getMensagem(),
                dados.getTopico().getCurso().getNome(),
                dados.getDataCriacao(),
                dados.getAutor().getNome(),
                dados.getSolucao()
        );
    }
}
