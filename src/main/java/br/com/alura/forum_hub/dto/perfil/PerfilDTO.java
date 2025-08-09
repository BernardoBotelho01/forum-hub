package br.com.alura.forum_hub.dto.perfil;

import br.com.alura.forum_hub.model.Perfil;

public record PerfilDTO(
        String nome
) {
    public PerfilDTO(Perfil dados) {
        this(
                dados.getNome()
        );
    }
}
