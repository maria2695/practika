package com.example.demo.controller;

import com.example.demo.dto.ingredient.IngredientInfoDto;
import com.example.demo.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

   @PostMapping
    public IngredientInfoDto createIngredient(@RequestBody IngredientInfoDto createIngredientDTO){
       return ingredientService.create(createIngredientDTO);
   }
   @GetMapping
   public IngredientInfoDto readIngredient(@RequestParam Long id){
       return ingredientService.read(id);
   }
   @PutMapping
   public IngredientInfoDto updateIngredient(@RequestBody IngredientInfoDto updateIngredientDTO, @RequestBody Long id){
       return ingredientService.update(updateIngredientDTO, id);
   }
  @DeleteMapping
   public void deleteIngredient(@RequestParam Long id){
       ingredientService.delete(id);
   }
   @GetMapping("/list")
   public List<IngredientInfoDto> ingredientList(){
       return ingredientService.getAll();
   }
}
