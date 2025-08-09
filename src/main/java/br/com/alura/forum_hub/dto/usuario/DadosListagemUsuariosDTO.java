package br.com.alura.forum_hub.dto.usuario;

import br.com.alura.forum_hub.model.Perfil;
import br.com.alura.forum_hub.model.Usuario;

import java.util.Set;
import java.util.stream.Collectors;

public record DadosListagemUsuariosDTO(
        long id,
        String nome,
        String email,
        Set<String> perfis
) {

    public DadosListagemUsuariosDTO(Usuario dados) {
        this(
                dados.getId(),
                dados.getNome(),
                dados.getEmail(),
                dados.getPerfis().stream()
                        .map(Perfil::getNome)
                        .collect(Collectors.toSet())

        );
    }
}