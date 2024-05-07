package com.jesus.alex.testBank.service.impl;

import com.jesus.alex.testBank.model.Transactions;
import com.jesus.alex.testBank.model.dto.ReportDTO;
import com.jesus.alex.testBank.respository.TransactionRepository;
import com.jesus.alex.testBank.service.TransactionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public ReportDTO getDailyReport() {

        Calendar calendar = Calendar.getInstance();
        Date startDate = getInitalDate(calendar);
        Date finalDate = getFinalDate(calendar);

        List<Transactions> transactions = transactionRepository.findByDate(startDate, finalDate);

        ReportDTO report = new ReportDTO();
        report.setTransactions(transactions);

        getReportTotalValue(transactions, report);
        report.setDate(startDate);
        return report;
    }

    private static void getReportTotalValue(List<Transactions> transactions, ReportDTO report) {
        BigDecimal total = new BigDecimal("0.0");

        for(Transactions transaction: transactions){
            total = total.add(transaction.getValue());
        }

        report.setTotal(total);
    }

    private static Date getInitalDate(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);

        return calendar.getTime();
    }

    private static Date getFinalDate(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }
}
