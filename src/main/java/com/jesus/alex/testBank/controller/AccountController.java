package com.jesus.alex.testBank.controller;

import com.jesus.alex.testBank.model.dto.CustomersBalancesDTO;
import com.jesus.alex.testBank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/balances")
    public ResponseEntity<CustomersBalancesDTO> getBalance() {
        return ResponseEntity.ok(accountService.getBalances());
    }


}
