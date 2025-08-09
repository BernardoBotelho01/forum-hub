package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.dto.resposta.DadosListagemRespostaDTO;
import br.com.alura.forum_hub.dto.resposta.DadosRespostaDTO;
import br.com.alura.forum_hub.model.Resposta;
import br.com.alura.forum_hub.repository.CursoRepository;
import br.com.alura.forum_hub.repository.RespostaRepository;
import br.com.alura.forum_hub.repository.TopicoRepository;
import br.com.alura.forum_hub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository; // <-- injeta

    @Transactional
    public Resposta salvar(DadosRespostaDTO dto) {
        final String nomeCurso = dto.topico().trim();
        final String nomeAutor = dto.autor().trim();

        var curso = cursoRepository.findByNomeIgnoreCase(nomeCurso)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Curso não encontrado: '" + nomeCurso + "'. Verifique o nome exato."));

        var topico = topicoRepository.findFirstByCursoOrderByIdDesc(curso)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Não há Tópico vinculado ao curso '" + curso.getNome()
                                + "'. Crie um tópico para esse curso antes de responder."));

        var autor = usuarioRepository.findByNome(nomeAutor)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Autor não encontrado: '" + nomeAutor + "'"));

        var resposta = new Resposta(
                dto.mensagem(),
                topico,
                autor,
                (dto.solucao() == null || dto.solucao().isBlank()) ? "" : dto.solucao()
        );

        return respostaRepository.save(resposta);
    }

    public Page<DadosListagemRespostaDTO> listar(Pageable paginacao) {
        return respostaRepository.findAll(paginacao).map(DadosListagemRespostaDTO::new);
    }
}
