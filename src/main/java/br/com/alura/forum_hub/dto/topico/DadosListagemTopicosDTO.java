package br.com.alura.forum_hub.dto.topico;

import br.com.alura.forum_hub.dto.autor.AutorDTO;
import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.model.Topico;

import java.time.LocalDateTime;

public record DadosListagemTopicosDTO(

        Long id,
        String titulo,
        String mensagem,
        String datacriacao,
        String status,
        String autor,
        String curso
) {
    public DadosListagemTopicosDTO(Topico dados) {
        this(
                dados.getId(),
                dados.getTitulo(),
                dados.getMensagem(),
                dados.getDataCriacao().toString(),
                dados.getStatus(),
                dados.getAutor().getNome(),
                dados.getCurso().getNome()
        );
    }
}
