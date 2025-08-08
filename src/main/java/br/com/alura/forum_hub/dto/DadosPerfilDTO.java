package br.com.alura.forum_hub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosPerfilDTO(

        @NotBlank
        String nome
) {
}
