package com.jesus.alex.testBank.model.dto;

import com.jesus.alex.testBank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomersDTO {

    private List<Customer> customers;
}
