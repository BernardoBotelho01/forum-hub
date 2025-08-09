package br.com.alura.forum_hub.dto.resposta;

import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosRespostaDTO(

        @NotBlank
        String mensagem,
        @NotNull
        Topico topico,
        @NotNull
        LocalDateTime dataCriacao,
        @NotNull
        Usuario autor,
        @NotBlank
        String solucao
) {
}
