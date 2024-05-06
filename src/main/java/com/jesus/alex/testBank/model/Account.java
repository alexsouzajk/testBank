package com.jesus.alex.testBank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name= "account")
@NoArgsConstructor
public class Account implements Serializable {

    @Id
    @JsonProperty("accountNumber")
    private Long id;

    @Column(name = "balance", precision=15, scale=2)
    private BigDecimal balance = new BigDecimal("0.0");

}
