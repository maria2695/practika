package com.example.demo.services.impl;

import com.example.demo.entities.Drink;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.services.DrinkService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.support.DefaultRepositoryInvokerFactory;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    @Override
    public Drink create(Drink drink) {
        if(drink != null){
            return drinkRepository.save(drink);
        }
        throw new NullEntityReferenceException("Drink cannot be 'null");
    }

    @Override
    public Drink getDrinkById(Long id) {
        return drinkRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Drink with id" + id + "not found")
        );
    }

    @Override
    public Drink update(Drink drink) {
        if(drink != null){
            getDrinkById(drink.getId());
            return drinkRepository.save(drink);
        }
        throw new NullEntityReferenceException("Drink cannot be 'null");
    }

    @Override
    public void delete(Long id) {
        Drink drink = getDrinkById(id);
        drinkRepository.delete(drink);
    }
    @Override
    public List<Drink> listOfDrinks() {
        return drinkRepository.findAll();
    }

}
