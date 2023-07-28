package com.example.demo.dto.balance;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class BalanceInfoDto {
    @NotNull
    private double balanceAmount;
    private Long clientId;
    private Date lastTransactionDate;
}
