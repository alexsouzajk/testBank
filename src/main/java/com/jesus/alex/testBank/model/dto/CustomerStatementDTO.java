package com.jesus.alex.testBank.model.dto;

import com.jesus.alex.testBank.model.Transactions;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerStatementDTO {

    private Long customerId;

    private List<Transactions> transactions;

}
