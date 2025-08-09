package br.com.alura.forum_hub.model;

import br.com.alura.forum_hub.dto.curso.DadosCursoDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity
@Table(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false)
    private String categoria;

    public Curso(@Valid DadosCursoDTO dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }
}
