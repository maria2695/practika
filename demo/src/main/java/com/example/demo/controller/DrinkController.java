package com.example.demo.controller;

import com.example.demo.dto.drink.CreateDrinkDTO;
import com.example.demo.dto.drink.GetAllDrinksDTO;
import com.example.demo.dto.drink.ReadDrinkDTO;
import com.example.demo.dto.drink.UpdateDrinkDTO;
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
    public CreateDrinkDTO createDrink(@RequestBody CreateDrinkDTO createDrinkDTO){
        return drinkService.create(createDrinkDTO);
    }
    @GetMapping("/{id}")
    public ReadDrinkDTO readDrink(@PathVariable Long id){
        return drinkService.read(id);
    }
    @PutMapping("/{id}")
    public UpdateDrinkDTO updateDrink(@RequestBody UpdateDrinkDTO updateDrinkDTO, @RequestParam Long id){
        return drinkService.update(updateDrinkDTO, id);
    }
    @DeleteMapping("/{id}")
    public void deleteDrink( @RequestParam Long id){
        drinkService.delete(id);
    }
    @GetMapping("/list")
    public List<GetAllDrinksDTO> drinkList(){
        return drinkService.getAll();
    }
}
