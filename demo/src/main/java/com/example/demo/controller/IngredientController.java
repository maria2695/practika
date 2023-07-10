package com.example.demo.controller;

import com.example.demo.entities.Ingredient;
import com.example.demo.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

   @PostMapping("/create")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient){
       return ingredientService.create(ingredient);
   }
   @GetMapping("/{id}")
   public Ingredient readIngredient(@PathVariable Long id){
       return ingredientService.read(id);
   }
   @PutMapping("/{id}")
   public Ingredient updateIngredient(@RequestBody Ingredient ingredient,@PathVariable Long id){
       return ingredientService.update(ingredient, id);
   }
  @DeleteMapping("/{id}")
   public void deleteIngredient(@PathVariable Long id){
       ingredientService.delete(id);
   }
   @GetMapping("/list")
   public List<Ingredient> ingredientList(){
       return ingredientService.getAll();
   }
}
