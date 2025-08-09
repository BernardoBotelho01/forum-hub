package br.com.alura.forum_hub.dto.topico;

import br.com.alura.forum_hub.model.Topico;
import jakarta.validation.constraints.NotBlank;

public record DadosTopicosDTO(

        @NotBlank String categoria,
        @NotBlank String mensagem,
        @NotBlank String status,
        @NotBlank String nomeAutor,
        @NotBlank String nomeCurso

) {

    public DadosTopicosDTO(Topico dados) {
        this(
                dados.getCurso().getCategoria(),
                dados.getMensagem(),
                dados.getStatus(),
                dados.getAutor().getNome(),
                dados.getCurso().getNome()
        );
    }
}
