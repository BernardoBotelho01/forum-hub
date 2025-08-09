package br.com.alura.forum_hub.dto.topico;

import br.com.alura.forum_hub.model.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopicoDTO(

        long id,
        String titulo,
        String mensagem,
        String status,
        String autor,
        String curso
) {
}