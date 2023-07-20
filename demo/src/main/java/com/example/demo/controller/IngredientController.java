package com.example.demo.controller;

import com.example.demo.dto.ingredient.CreateIngredientDTO;
import com.example.demo.dto.ingredient.GetAllIngredientDTO;
import com.example.demo.dto.ingredient.ReadIngredientDTO;
import com.example.demo.dto.ingredient.UpdateIngredientDTO;
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
    public CreateIngredientDTO createIngredient(@RequestBody CreateIngredientDTO createIngredientDTO){
       return ingredientService.create(createIngredientDTO);
   }
   @GetMapping("/{id}")
   public ReadIngredientDTO readIngredient(@RequestParam Long id){
       return ingredientService.read(id);
   }
   @PutMapping("/{id}")
   public UpdateIngredientDTO updateIngredient(@RequestBody UpdateIngredientDTO updateIngredientDTO, @RequestBody Long id){
       return ingredientService.update(updateIngredientDTO, id);
   }
  @DeleteMapping("/{id}")
   public void deleteIngredient(@RequestParam Long id){
       ingredientService.delete(id);
   }
   @GetMapping("/list")
   public List<GetAllIngredientDTO> ingredientList(){
       return ingredientService.getAll();
   }
}
