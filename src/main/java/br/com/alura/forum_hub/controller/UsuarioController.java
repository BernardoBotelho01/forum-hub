package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.usuario.DadosListagemUsuariosDTO;
import br.com.alura.forum_hub.dto.usuario.DadosLoginUsuarioDTO;
import br.com.alura.forum_hub.dto.usuario.DadosUsuarioDTO;
import br.com.alura.forum_hub.dto.usuario.UsuarioDTO;
import br.com.alura.forum_hub.model.Usuario;
import br.com.alura.forum_hub.security.DadosTokenJWT;
import br.com.alura.forum_hub.security.TokenService;
import br.com.alura.forum_hub.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final AuthenticationManager manager;

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosUsuarioDTO dados){
        var usuario = usuarioService.salvar(dados);

        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosLoginUsuarioDTO dados){
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var autenticacao = manager.authenticate(autenticacaoToken);

        var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity desativarTopico(@PathVariable Long id) {
        usuarioService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity ativarTopico(@PathVariable Long id) {
        usuarioService.ativar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuariosDTO>> listagemDeTopicos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return ResponseEntity.ok(usuarioService.listar(paginacao));

    }
}
