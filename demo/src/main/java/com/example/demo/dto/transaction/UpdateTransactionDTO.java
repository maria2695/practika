package com.example.demo.dto.transaction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class UpdateTransactionDTO {
    private Long id;
    private Date transactionDate;
    private double transactionAmount;
    private Long clientId;
}
