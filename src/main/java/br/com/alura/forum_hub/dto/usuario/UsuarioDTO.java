package br.com.alura.forum_hub.dto.usuario;

import br.com.alura.forum_hub.model.Perfil;
import br.com.alura.forum_hub.model.Usuario;

import java.util.Set;
import java.util.stream.Collectors;

public record UsuarioDTO(
        String nome,
        String email,
        Set<String> perfis
) {

    public UsuarioDTO(Usuario dados) {
        this(
                dados.getNome(),
                dados.getEmail(),
                dados.getPerfis().stream()
                        .map(Perfil::getNome)
                        .collect(Collectors.toSet())

        );
    }
}
