package br.com.alura.forum_hub.dto;

import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.model.Topico;

public record TopicosDTO(

        long id,
        String titulo,
        String mensagem,
        String ator,
        Curso curso
) {
    public TopicosDTO(Topico dados) {

        this(
                dados.getId(),
                dados.getTitulo(),
                dados.getMensagem(),
                dados.getAutor().getNome(),
                dados.getCurso()
        );
    }
}
