package br.com.alura.forum_hub.dto.perfil;

import br.com.alura.forum_hub.model.Perfil;
import jakarta.validation.constraints.NotBlank;

public record DadosPerfilDTO(

        @NotBlank
        String nome
) {
        public DadosPerfilDTO(Perfil perfil) {
                this(
                        perfil.getNome()
                );
        }
}
