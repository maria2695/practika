package com.example.demo.dto.admin;

import com.example.demo.entities.Staff;
import com.example.demo.entities.Transaction;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class AdminInfoDto {

    private double balance;
    @NotEmpty
    private List<Transaction> transactionList;
    private Staff weeklySalary;
}
