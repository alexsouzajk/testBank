package com.jesus.alex.testBank.controller;

import com.jesus.alex.testBank.model.Customer;
import com.jesus.alex.testBank.model.dto.CustomerStatementDTO;
import com.jesus.alex.testBank.service.AccountService;
import com.jesus.alex.testBank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    ResponseEntity<Customer> createCustomer(@RequestBody Customer request) throws URISyntaxException {

        Customer customer = customerService.createCustomer(request);

        return ResponseEntity.created(new URI("/customers/"+ customer.getId())).body(customer);
    }

    @GetMapping("/{customer}/accounts")
    public ResponseEntity<CustomerStatementDTO> getCustomerClientAccountStatement(@PathVariable("customer") Long customerId){

        CustomerStatementDTO customerStatement = customerService.getCustomerAccountStatement(customerId);

        return ResponseEntity.ok(customerStatement);
    }

}
