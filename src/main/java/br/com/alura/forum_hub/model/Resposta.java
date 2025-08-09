package br.com.alura.forum_hub.model;

import br.com.alura.forum_hub.dto.resposta.DadosRespostaDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    private Usuario autor;

    @Column(nullable = false)
    private String solucao;

    public Resposta(@Valid DadosRespostaDTO dados) {
        this.mensagem = dados.mensagem();
        this.topico = dados.topico();
        this.dataCriacao = getDataCriacao();
        this.autor = dados.autor();
        this.solucao = dados.solucao();
    }
}
