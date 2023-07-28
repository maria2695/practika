package com.example.demo.controller;

import com.example.demo.dto.drink.DrinkInfoDto;
import com.example.demo.services.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/drinks")
public class DrinkController {

    private final DrinkService drinkService;
    @PostMapping
    public DrinkInfoDto createDrink(@RequestBody DrinkInfoDto createDrinkDTO){
        return drinkService.create(createDrinkDTO);
    }
    @GetMapping
    public DrinkInfoDto readDrink(@PathVariable Long id){
        return drinkService.read(id);
    }
    @PutMapping
    public DrinkInfoDto updateDrink(@RequestBody DrinkInfoDto updateDrinkDTO, @RequestParam Long id){
        return drinkService.update(updateDrinkDTO, id);
    }
    @DeleteMapping
    public void deleteDrink( @RequestParam Long id){
        drinkService.delete(id);
    }
    @GetMapping("/list")
    public List<DrinkInfoDto> drinkList(){
        return drinkService.getAll();
    }
}
