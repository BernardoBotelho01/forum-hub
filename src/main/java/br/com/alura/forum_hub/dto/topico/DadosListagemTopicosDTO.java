package br.com.alura.forum_hub.dto.topico;

import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.model.Usuario;

public record DadosListagemTopicosDTO(

        Long id,
        String categoria,
        String mensagem,
        String datacriacao,
        String status,
        String autor,
        String curso
) {
    public DadosListagemTopicosDTO(Topico dados) {
        this(
                dados.getId(),
                dados.getCurso().getCategoria(),
                dados.getMensagem(),
                dados.getDataCriacao().toString(),
                dados.getStatus(),
                dados.getAutor().getNome(),
                dados.getCurso().getNome()
        );
    }
}
