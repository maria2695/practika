package com.example.demo.services;


import com.example.demo.entities.Drink;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DrinkService {
    Drink create(Drink drink);
    Drink getDrinkById(Long id);
    Drink update(Drink drink);
    void delete(Long id);
    List<Drink> listOfDrinks();

}
