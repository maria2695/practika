package com.example.demo.services.impl;

import com.example.demo.entities.Drink;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.services.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;
    @Override
    public Drink create(Drink drink) {
        return drinkRepository.save(drink);
    }
    @Override
    public Drink read(Long id) {
        return drinkRepository.findById(id).orElse(null);
    }

    @Override
    public Drink update(Drink drink, Long id) {
        Drink exitedDrink = drinkRepository.findById(id).orElse(null);
        if(exitedDrink != null){
            exitedDrink.setName(drink.getName());
            exitedDrink.setPrice(drink.getPrice());
            exitedDrink.setPresence(drink.getPresence());
        }
        return drinkRepository.save(drink);
    }

    @Override
    public void delete(Long id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public List<Drink> getAll() {
        return drinkRepository.findAll();
    }
}
