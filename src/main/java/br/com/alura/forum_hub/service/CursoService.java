package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.model.Curso;
import br.com.alura.forum_hub.repository.CursoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository repository;

    @Transactional
    public Curso salvar(Curso curso){
        return repository.save(curso);
    }
}
