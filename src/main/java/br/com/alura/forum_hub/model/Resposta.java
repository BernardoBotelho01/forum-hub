package br.com.alura.forum_hub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Resposta{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    public Usuario autor;

    @Column(nullable = false)
    private String solucao = "";


    public Resposta(String mensagem, Topico topico, Usuario autor, String solucao) {
        this.mensagem = mensagem;
        this.topico = topico;
        this.dataCriacao = LocalDateTime.now();
        this.autor = autor;
        this.solucao = solucao;
    }

}
