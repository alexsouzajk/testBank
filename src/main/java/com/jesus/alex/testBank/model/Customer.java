package com.jesus.alex.testBank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "customer")
@Validated
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

}
