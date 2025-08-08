package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository repository;

    @Transactional
    public Topico salvarTopico (Topico topico){
        return repository.save(topico);
    }
}
