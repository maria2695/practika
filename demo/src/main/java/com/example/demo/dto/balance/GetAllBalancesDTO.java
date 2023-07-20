package com.example.demo.dto.balance;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class GetAllBalancesDTO {
    private Long id;
    private double balanceAmount;
    private Long clientId;
    private Date lastTransactionDate;
}
