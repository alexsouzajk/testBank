package com.jesus.alex.testBank.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jesus.alex.testBank.model.Transactions;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ReportDTO {

    private BigDecimal total;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date;

    private List<Transactions>  transactions;

}
