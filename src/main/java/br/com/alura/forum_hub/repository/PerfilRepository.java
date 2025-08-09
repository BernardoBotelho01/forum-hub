package br.com.alura.forum_hub.repository;

import br.com.alura.forum_hub.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
