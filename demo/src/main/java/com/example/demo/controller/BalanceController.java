package com.example.demo.controller;

import com.example.demo.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/balances")
public class BalanceController {

    private final BalanceService balanceService;
    @GetMapping("/list")
    public void getAll(){
        balanceService.getAll();
    }
}
