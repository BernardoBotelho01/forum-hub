package br.com.alura.forum_hub.dto.autor;

import br.com.alura.forum_hub.model.Perfil;
import br.com.alura.forum_hub.model.Usuario;

import java.util.Set;
import java.util.stream.Collectors;

public record AutorDTO (
        Long id,
        String nome,
        Set<String> perfis
) {
    public AutorDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getPerfis().stream().map(Perfil::getNome).collect(Collectors.toSet())
        );
    }
}