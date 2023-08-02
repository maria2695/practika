package com.example.demo.dto.transaction;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class TransactionInfoDto {
    private Date transactionDate;
    @NotNull
    private double transactionAmount;
    private Long clientId;
}
