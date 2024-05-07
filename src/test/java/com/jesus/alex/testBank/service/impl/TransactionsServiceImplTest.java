package com.jesus.alex.testBank.service.impl;

import com.jesus.alex.testBank.model.Transactions;
import com.jesus.alex.testBank.respository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionsServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionsServiceImpl service;

    @Test
    void getDailyReport() {

        List<Transactions> list = new ArrayList<>();

        Transactions transaction = new Transactions();
        transaction.setValue(new BigDecimal("200.0"));

        list.add(transaction);

        when(transactionRepository.findByDate(any(), any())).thenReturn(list);

        service.getDailyReport();

    }
}