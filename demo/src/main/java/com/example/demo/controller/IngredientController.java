package com.example.demo.controller;

import com.example.demo.entities.Ingredient;
import com.example.demo.entities.Transaction;
import com.example.demo.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza/ingredient")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @PostMapping("/create")
    public Ingredient create(@RequestBody Ingredient ingredient){
        return ingredientService.create(ingredient);
    }

    @GetMapping("/{id}")
    public Ingredient getByTransactionId(@PathVariable Long id){
        return ingredientService.getIngredientById(id);
    }

    @PutMapping("/{id}")
    public Ingredient update(@PathVariable Long id, @RequestBody Ingredient ingredient){
        ingredient.setId(id);
        return ingredientService.update(ingredient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        ingredientService.delete(id);
    }

    @GetMapping
    public List<Ingredient> getAll(){
        return ingredientService.getAll();
    }

}
