package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.topico.DadosAtualizacaoTopicoDTO;
import br.com.alura.forum_hub.dto.topico.DadosListagemTopicosDTO;
import br.com.alura.forum_hub.dto.topico.DadosTopicosDTO;
import br.com.alura.forum_hub.dto.topico.TopicosDTO;
import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.repository.CursoRepository;
import br.com.alura.forum_hub.repository.UsuarioRepository;
import br.com.alura.forum_hub.service.TopicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("topicos")
public class TopicoController {

    private final TopicoService topicoService;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity cadastroTopico(@RequestBody @Valid DadosTopicosDTO dados) {

        var autor = usuarioRepository.findByNome(dados.nomeAutor())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        var curso = cursoRepository.findByNomeIgnoreCase(dados.nomeCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));

        var topico = new Topico(dados.categoria(), dados.mensagem(), autor, curso);

        var topicoSalvo = topicoService.salvarTopico(topico);

        return ResponseEntity.ok().body(new TopicosDTO(topicoSalvo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicosDTO>> listagemDeTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        return ResponseEntity.ok(topicoService.listar(paginacao));

    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@RequestBody @PathVariable Long id) {
        var topico = topicoService.buscarPorId(id);
        return ResponseEntity.ok(new DadosListagemTopicosDTO(topico));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody DadosAtualizacaoTopicoDTO dados) {
        var topico = topicoService.atualizar(id, dados);
        return ResponseEntity.ok(new TopicosDTO(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity desativarTopico(@PathVariable Long id) {
        topicoService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity ativarTopico(@PathVariable Long id) {
        topicoService.ativar(id);
        return ResponseEntity.noContent().build();
    }
}