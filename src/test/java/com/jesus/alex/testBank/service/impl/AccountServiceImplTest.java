package com.jesus.alex.testBank.service.impl;

import com.jesus.alex.testBank.respository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository repository;

    @InjectMocks
    private AccountServiceImpl service;

    @Test
    void getBalances() {
        when(repository.totalBalance()).thenReturn(new BigDecimal("200.20"));

        assertNotNull(service.getBalances());
    }
}