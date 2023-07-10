package com.example.demo.controller;

import com.example.demo.entities.Drink;
import com.example.demo.services.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/drinks")
public class DrinkController {

    private final DrinkService drinkService;
    @PostMapping("/create")
    public Drink createDrink(@RequestBody Drink drink){
        return drinkService.create(drink);
    }
    @GetMapping("/{id}")
    public Drink readDrink(@PathVariable Long id){
        return drinkService.read(id);
    }
    @PutMapping("/{id}")
    public Drink updateDrink(@RequestBody Drink drink, @PathVariable Long id){
        return drinkService.update(drink, id);
    }
    @DeleteMapping("/{id}")
    public void deleteDrink( @PathVariable Long id){
        drinkService.delete(id);
    }
    @GetMapping("/list")
    public List<Drink> drinkList(){
        return drinkService.getAll();
    }
}
