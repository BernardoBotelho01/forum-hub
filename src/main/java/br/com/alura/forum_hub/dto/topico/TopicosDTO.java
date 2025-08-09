package br.com.alura.forum_hub.dto.topico;

import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.model.Topico;

public record TopicosDTO(
        String titulo,
        String mensagem,
        String status,
        String autor,
        String curso
) {
    public TopicosDTO(Topico dados) {
        this(
                dados.getTitulo(),
                dados.getMensagem(),
                dados.getStatus(),
                dados.getAutor().getNome(),
                dados.getCurso().getNome()
        );
    }
}
