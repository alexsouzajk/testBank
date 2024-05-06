package com.jesus.alex.testBank.service;

import com.jesus.alex.testBank.model.Customer;
import com.jesus.alex.testBank.model.dto.CustomerStatementDTO;

public interface CustomerService {

    Customer createCustomer(Customer request);

    CustomerStatementDTO getCustomerAccountStatement(Long customerId);

}
