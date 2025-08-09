package br.com.alura.forum_hub.model;

import br.com.alura.forum_hub.dto.perfil.DadosPerfilDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "perfis")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false ,unique = true)
    private String nome;

    public Perfil(DadosPerfilDTO dados) {
        this.nome = dados.nome();
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + nome;
    }
}
