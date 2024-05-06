package com.jesus.alex.testBank.service.impl;

import com.jesus.alex.testBank.model.dto.CustomersBalancesDTO;
import com.jesus.alex.testBank.respository.AccountRepository;
import com.jesus.alex.testBank.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CustomersBalancesDTO getBalances() {
        log.info("Início da busca do saldo da conta de todos os clientes");

        CustomersBalancesDTO balances = new CustomersBalancesDTO();
        balances.setTotalBalance(accountRepository.totalBalance());

        log.info("Fim da busca do saldo da conta de todos os clientes");
        return balances;
    }
}
