package br.com.alura.forum_hub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCursoDTO(

        @NotBlank
        String nome,
        @NotBlank
        String categoria
) {
}
