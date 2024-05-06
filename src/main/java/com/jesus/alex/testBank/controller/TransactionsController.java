package com.jesus.alex.testBank.controller;

import com.jesus.alex.testBank.model.dto.ReportDTO;
import com.jesus.alex.testBank.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/reports")
    public ResponseEntity<ReportDTO> getDailyReport() {

        return ResponseEntity.ok(transactionsService.getDailyReport());
    }

}
