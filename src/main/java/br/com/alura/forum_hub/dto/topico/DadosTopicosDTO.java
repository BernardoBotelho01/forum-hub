package br.com.alura.forum_hub.dto.topico;

import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosTopicosDTO(

        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank String status,
        @NotBlank String nomeAutor,
        @NotBlank String nomeCurso

) {

    public DadosTopicosDTO(Topico dados) {
        this(
                dados.getTitulo(),
                dados.getMensagem(),
                dados.getStatus(),
                dados.getAutor().getNome(),
                dados.getCurso().getNome()
        );
    }
}
