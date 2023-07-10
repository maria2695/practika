package com.example.demo.controller;

import com.example.demo.entities.Balance;
import com.example.demo.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/balances")
public class BalanceController {
    private final BalanceService balanceService;

    @PostMapping("/closing-time")
    public void saveCurrentBalance(@RequestBody Balance balance){
        balanceService.saveCurrentBalance(balance);
    }




}
