package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.dto.usuario.DadosListagemUsuariosDTO;
import br.com.alura.forum_hub.dto.usuario.DadosUsuarioDTO;
import br.com.alura.forum_hub.model.Usuario;
import br.com.alura.forum_hub.repository.PerfilRepository;
import br.com.alura.forum_hub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final PerfilRepository perfilRepository;

@Transactional
public Usuario salvar(DadosUsuarioDTO dados) {

    var perfis = new HashSet<>(perfilRepository.findAllById(dados.perfisIds()));

    Usuario usuario = new Usuario();
    usuario.setNome(dados.nome());
    usuario.setEmail(dados.email());
    usuario.setSenha(passwordEncoder.encode(dados.senha()));
    usuario.setPerfis(perfis);

    return repository.save(usuario);
}

    @Transactional
    public void desativar(Long id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);

        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.desativar();
            repository.save(usuario);
        }else{
            throw new EntityNotFoundException("Id não encontrado para ser desativado");
        }

    }

    @Transactional
    public void ativar(Long id) {
        var usuario = repository.getReferenceById(id);
        usuario.ativar();
    }

    public Page<DadosListagemUsuariosDTO> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemUsuariosDTO::new);

    }
}
