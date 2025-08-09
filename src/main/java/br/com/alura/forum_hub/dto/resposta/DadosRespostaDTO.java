package br.com.alura.forum_hub.dto.resposta;

import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosRespostaDTO(

        @NotBlank
        String mensagem,
        @NotBlank
        String topico,
        @NotBlank
        String autor,
        String solucao
) {
}
