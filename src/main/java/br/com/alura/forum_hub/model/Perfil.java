package br.com.alura.forum_hub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Perfils")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false ,unique = true)
    private String nome;

}
