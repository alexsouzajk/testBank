package com.jesus.alex.testBank.service.impl;

import com.jesus.alex.testBank.model.Account;
import com.jesus.alex.testBank.model.Customer;
import com.jesus.alex.testBank.model.Transactions;
import com.jesus.alex.testBank.model.dto.CustomerStatementDTO;
import com.jesus.alex.testBank.model.dto.CustomersDTO;
import com.jesus.alex.testBank.respository.CustomerRepository;
import com.jesus.alex.testBank.respository.TransactionRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    CustomerServiceImpl service;

    @Test
    void createCustomer() {

        Customer customer = new Customer();
        customer.setAge(21);
        customer.setName("Name Test");
        customer.setEmail("email@email.com");
        Account account = new Account();
        account.setId(1212L);
        account.setBalance(new BigDecimal("144.3"));
        customer.setAccount(account);

        when(customerRepository.save(customer)).thenReturn(customer);
        when(transactionRepository.save(any(Transactions.class))).thenReturn(new Transactions());
        assertNotNull(service.createCustomer(customer));
    }

    @Test
    void getAllCustomers() {
        when(customerRepository.findAll()).thenReturn(new ArrayList<Customer>());

        Object response = service.getAllCustomers();

        assertInstanceOf(CustomersDTO.class, response);
    }

    @Test
    void getCustomerAccountStatement() {
        Transactions transaction = new Transactions();
        List<Transactions> list = new ArrayList<>();
        list.add(transaction);

        Optional<List<Transactions>> optional = Optional.of(list);

        when(transactionRepository.findByCustomerId(1L)).thenReturn(optional);

        Object response = service.getCustomerAccountStatement(1L);

        assertInstanceOf(CustomerStatementDTO.class, response);
    }

    @Test
    void getCustomerAccountStatementThrowsResponseStatusException() {
        assertThrows(ResponseStatusException.class, () ->{

            Optional<List<Transactions>> optional = Optional.of(new ArrayList<Transactions>());

            when(transactionRepository.findByCustomerId(1L)).thenReturn(optional);

            service.getCustomerAccountStatement(1L);
        });
    }
}