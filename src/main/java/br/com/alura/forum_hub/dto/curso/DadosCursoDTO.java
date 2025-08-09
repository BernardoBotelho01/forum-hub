package br.com.alura.forum_hub.dto.curso;

import br.com.alura.forum_hub.model.Curso;
import jakarta.validation.constraints.NotBlank;

public record DadosCursoDTO(

        @NotBlank
        String nome,
        @NotBlank
        String categoria
) {
        public DadosCursoDTO(Curso dados) {
                this(
                        dados.getNome(),
                        dados.getCategoria()
                );
        }
}
