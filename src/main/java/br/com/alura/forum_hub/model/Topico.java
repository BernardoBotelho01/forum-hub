package br.com.alura.forum_hub.model;

import br.com.alura.forum_hub.dto.topico.DadosAtualizacaoTopicoDTO;
import br.com.alura.forum_hub.dto.topico.DadosTopicosDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false , unique = true)
    private String titulo;
    @Column(nullable = false , unique = true)
    private String mensagem;
    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private String status;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Resposta> respostas = new ArrayList<>();


    public Topico(String titulo, String mensagem, Usuario autor, Curso curso) {
        this.ativo = true;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = LocalDateTime.now();
        this.autor = autor;
        this.curso = curso;
        this.status = "Aberto";
    }

    public void atualizarInformacoes(DadosAtualizacaoTopicoDTO dados) {
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.status() != null){
            this.status = dados.status();
        }

    }

    public void desativarTopico() {
        this.ativo = false;
    }

    public void ativarTopico() {
        this.ativo = true;
    }
}
