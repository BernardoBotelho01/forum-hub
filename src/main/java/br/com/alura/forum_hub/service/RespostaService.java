package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.model.Resposta;
import br.com.alura.forum_hub.repository.RespostaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RespostaService {

    private final RespostaRepository repository;

    @Transactional
    public Resposta salvar(Resposta resposta){
        return repository.save(resposta);
    }
}
