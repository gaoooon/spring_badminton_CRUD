package com.yonex.badminton.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "racket_id")
    private Racket racket;

    public Player(String name, Integer age, Racket racket) {
        this.name = name;
        this.age = age;
        this.racket = racket;
    }
}
