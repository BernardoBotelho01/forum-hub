package br.com.alura.forum_hub.dto.curso;

import br.com.alura.forum_hub.model.Curso;

public record DadosListagemCursoDTO(
        long id,
        String nome,
        String categoria
) {

    public DadosListagemCursoDTO(Curso dados) {
        this(
                dados.getId(),
                dados.getNome(),
                dados.getCategoria()
        );
    }
}