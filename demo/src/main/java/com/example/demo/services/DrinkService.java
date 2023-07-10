package com.example.demo.services;



import com.example.demo.entities.Drink;

import java.util.List;

public interface DrinkService {
     Drink create(Drink drink);
     Drink read(Long id);
     Drink update(Drink drink, Long id);
     void delete(Long id);
     List<Drink> getAll();
}
