package com.jesus.alex.testBank.service.impl;

import com.jesus.alex.testBank.model.Customer;
import com.jesus.alex.testBank.model.Transactions;
import com.jesus.alex.testBank.model.dto.CustomerStatementDTO;
import com.jesus.alex.testBank.respository.CustomerRepository;
import com.jesus.alex.testBank.respository.TransactionRepository;
import com.jesus.alex.testBank.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    TransactionRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public Customer createCustomer(Customer request) {
        log.info("Início - cadastro de cliente ");

        Customer saved = customerRepository.save(request);

        saveFirstTransaction(saved);

        log.info("Fim - cadastro de cliente ");
        return saved;
    }

    @Override
    public CustomerStatementDTO getCustomerAccountStatement(Long customerId) {
        log.info("Início da busca de extrato do cliente: {}", customerId);
        Optional<List<Transactions>> optional = repository.findByCustomerId(customerId);
        if(optional.isEmpty() || optional.get().isEmpty()){
            log.error("Cliente {} não possui movimentações", customerId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma movimentação encontrada!");
        }

        log.info("Fim da busca de extrato do cliente: {}", customerId);
        return new CustomerStatementDTO(customerId, optional.get());
    }

    private void saveFirstTransaction(Customer saved) {
        Transactions transaction = new Transactions();
        transaction.setDestinationAccount(saved.getAccount());
        transaction.setDate(new Date());
        transaction.setValue(saved.getAccount().getBalance());
        transactionRepository.save(transaction);
    }
}
