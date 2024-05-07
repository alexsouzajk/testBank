package com.jesus.alex.testBank.service;

import com.jesus.alex.testBank.model.Customer;
import com.jesus.alex.testBank.model.dto.CustomerStatementDTO;
import com.jesus.alex.testBank.model.dto.CustomersDTO;

public interface CustomerService {

    Customer createCustomer(Customer request);

    CustomersDTO getAllCustomers();

    CustomerStatementDTO getCustomerAccountStatement(Long customerId);

}
