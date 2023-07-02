package com.example.demo.controller;

import com.example.demo.entities.Drink;
import com.example.demo.services.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza/drink")
@RequiredArgsConstructor
public class DrinkController {

    private final DrinkService drinkService;

    @PostMapping("/create")
    public Drink create(@RequestBody Drink drink){
        return drinkService.create(drink);
    }

    @GetMapping("/{id}")
    public Drink getByDrinkId(@PathVariable Long id){
        return drinkService.getDrinkById(id);
    }
    @PutMapping("/{id}")
    public Drink update(@PathVariable Long id, @RequestBody Drink drink) {
        drink.setId(id);
        return drinkService.update(drink);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        drinkService.delete(id);
    }

    @GetMapping
    public List<Drink> drinkList(){
        return drinkService.listOfDrinks();
    }

}
