package br.com.alura.forum_hub.repository;

import br.com.alura.forum_hub.model.Curso;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNomeIgnoreCase(String nome);

    Optional<Object> findByNome( String s);

    Optional<Curso> findByCategoriaIgnoreCase(String trim);
}
