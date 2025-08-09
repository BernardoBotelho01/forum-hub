package br.com.alura.forum_hub.service;

import br.com.alura.forum_hub.dto.topico.DadosAtualizacaoTopicoDTO;
import br.com.alura.forum_hub.dto.topico.DadosListagemTopicosDTO;
import br.com.alura.forum_hub.model.Topico;
import br.com.alura.forum_hub.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository repository;

    @Transactional
    public Topico salvarTopico (Topico topico){
        return repository.save(topico);
    }

    public Page<DadosListagemTopicosDTO> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemTopicosDTO::new);

    }

    public Topico buscarPorId(Long id) {
        var topico = repository.getReferenceById(id);
        return topico;
    }

    @Transactional
    public Topico atualizar(Long id, DadosAtualizacaoTopicoDTO dados){

        Optional<Topico> topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()){
            Topico topico = topicoOptional.get();
            topico.atualizarInformacoes(dados);
            return topico;
        }
        else {
            throw new EntityNotFoundException("Id não encontrado para fazer atualização do topico");
        }

    }

    public void desativar(Long id) {
        Optional<Topico> topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()){
            Topico topico = topicoOptional.get();
            topico.desativarTopico();
            repository.save(topico);
        }else{
            throw new EntityNotFoundException("Id não encontrado para ser desativado");
        }

    }

    @Transactional
    public void ativar(Long id) {
        var topico = repository.getReferenceById(id);
        topico.ativarTopico();
    }
}
