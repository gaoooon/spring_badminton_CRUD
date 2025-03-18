package com.yonex.badminton.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class BadmintonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    @NotNull
    private String name;

    @Column()
    @NotNull
    private Integer age;

    @Column()
    @NotNull
    private String racketName;

    public BadmintonEntity (String name, Integer age, String racketName) {
        this.name = name;
        this.age = age;
        this.racketName = racketName;
    }
}

// ORM: 객체 - 관계형디비 매치
// 디비 테이블을 객체로 매치!
