package com.jesus.alex.testBank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name= "transactions")
@NoArgsConstructor
public class Transactions implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private Date date;

    private BigDecimal value;

    @OneToOne
    private Account originAccount;

    @OneToOne
    private Account destinationAccount;

}
