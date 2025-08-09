package br.com.alura.forum_hub.dto.curso;

import br.com.alura.forum_hub.model.Curso;

public record CursoDTO(

        String nome,
        String categoria
) {

    public CursoDTO(Curso dados) {
        this(
                dados.getNome(),
                dados.getCategoria()
        );
    }
}
