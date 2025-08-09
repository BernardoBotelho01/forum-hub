package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.dto.usuario.DadosUsuarioDTO;
import br.com.alura.forum_hub.model.Usuario;
import br.com.alura.forum_hub.repository.PerfilRepository;
import br.com.alura.forum_hub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final PerfilRepository perfilRepository;

@Transactional
public Usuario salvar(DadosUsuarioDTO dados) {
    // Buscar os perfis pelo ID
    var perfis = new HashSet<>(perfilRepository.findAllById(dados.perfisIds()));

    // Montar o usuário
    Usuario usuario = new Usuario();
    usuario.setNome(dados.nome());
    usuario.setEmail(dados.email());
    usuario.setSenha(passwordEncoder.encode(dados.senha()));
    usuario.setPerfis(perfis);

    return repository.save(usuario);
}
}
