package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.model.Perfil;
import br.com.alura.forum_hub.repository.PerfilRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository repository;

    @Transactional
    public Perfil salvar(Perfil perfil) {
        return repository.save(perfil);
    }
}
