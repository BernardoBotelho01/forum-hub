package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.dto.curso.DadosListagemCursoDTO;
import br.com.alura.forum_hub.dto.resposta.DadosListagemRespostaDTO;
import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.repository.CursoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository repository;

    @Transactional
    public Curso salvar(Curso curso){
        return repository.save(curso);
    }

    public Page<DadosListagemCursoDTO> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCursoDTO::new);
    }

}
