package com.example.demo.services.impl;

import com.example.demo.entities.BalanceOfPizzeria;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.BalanceOfPizzeriaRepository;
import com.example.demo.services.BalanceOfPizzeriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceOfPizzeriaServiceImpl implements BalanceOfPizzeriaService {
    private final BalanceOfPizzeriaRepository balanceOfPizzeriaRepository;

    public BalanceOfPizzeriaServiceImpl(BalanceOfPizzeriaRepository balanceOfPizzeriaRepository){
        this.balanceOfPizzeriaRepository = balanceOfPizzeriaRepository;
    }

    @Override
    public BalanceOfPizzeria create(BalanceOfPizzeria balanceOfPizzeria) {
        if (balanceOfPizzeria != null) {
            return balanceOfPizzeriaRepository.save(balanceOfPizzeria);
        }
        throw new NullEntityReferenceException("Cannot be 'null'");
    }

    @Override
    public BalanceOfPizzeria getBalanceById(Long id) {
        return balanceOfPizzeriaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Not found"));
    }

    @Override
    public BalanceOfPizzeria update(BalanceOfPizzeria balanceOfPizzeria) {
        if(balanceOfPizzeria != null){
            getBalanceById(balanceOfPizzeria.getId());
            return balanceOfPizzeriaRepository.save(balanceOfPizzeria);
        }
        throw new NullEntityReferenceException("Cannot be 'null'");
    }

    @Override
    public void delete(Long id) {
        BalanceOfPizzeria balanceOfPizzeria= getBalanceById(id);
        balanceOfPizzeriaRepository.delete(balanceOfPizzeria);
    }

    @Override
    public List<BalanceOfPizzeria> getAll() {
        return balanceOfPizzeriaRepository.findAll();
    }
}
