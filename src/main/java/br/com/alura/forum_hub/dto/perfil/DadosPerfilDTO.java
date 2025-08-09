package br.com.alura.forum_hub.dto.perfil;

import jakarta.validation.constraints.NotBlank;

public record DadosPerfilDTO(

        @NotBlank
        String nome
) {
}
