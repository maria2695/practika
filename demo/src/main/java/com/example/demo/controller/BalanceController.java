package com.example.demo.controller;

import com.example.demo.dto.balance.BalanceInfoDto;
import com.example.demo.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/balances")
public class BalanceController {

    private final BalanceService balanceService;
    @GetMapping("/list")
    public List<BalanceInfoDto> agetAll(){
        return balanceService.getAll();
    }
}
