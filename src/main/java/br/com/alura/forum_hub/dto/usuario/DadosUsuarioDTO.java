package br.com.alura.forum_hub.dto.usuario;

import br.com.alura.forum_hub.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record DadosUsuarioDTO(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha,
        @NotNull
        Set<Long> perfisIds
) {
}
