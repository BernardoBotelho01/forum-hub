package br.com.alura.forum_hub.repository;

import br.com.alura.forum_hub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByStatus(String status, Pageable pageable);

    Page<Topico> findAllByAtivoTrue(Pageable paginacao);
}
