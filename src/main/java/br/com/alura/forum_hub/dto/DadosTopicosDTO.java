package br.com.alura.forum_hub.dto;

import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.model.Resposta;
import br.com.alura.forum_hub.model.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosTopicosDTO(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        LocalDateTime dataDescricao,
        @NotNull
        boolean status,
        @NotNull
        Usuario autor,
        @NotNull
        Curso curso,
        @NotNull
        Resposta respostas
) {
}
