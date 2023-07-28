package com.example.demo.services;

import com.example.demo.dto.transaction.TransactionInfoDto;

import java.util.List;

public interface TransactionService {
   TransactionInfoDto create(TransactionInfoDto transaction);
   TransactionInfoDto read(Long id);
   List<TransactionInfoDto> getAll();
}
