package br.com.alura.forum_hub.dto.topico;

import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.model.Topico;

public record TopicosDTO(
        String categoria,
        String mensagem,
        String status
) {
    public TopicosDTO(Topico dados) {
        this(
                dados.getCurso().getCategoria(),
                dados.getMensagem(),
                dados.getStatus()
        );
    }
}
