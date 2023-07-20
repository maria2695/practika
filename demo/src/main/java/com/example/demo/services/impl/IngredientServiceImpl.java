package com.example.demo.services.impl;

import com.example.demo.dto.ingredient.CreateIngredientDTO;
import com.example.demo.dto.ingredient.GetAllIngredientDTO;
import com.example.demo.dto.ingredient.ReadIngredientDTO;
import com.example.demo.dto.ingredient.UpdateIngredientDTO;
import com.example.demo.entities.Ingredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.services.IngredientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    @Transactional
    public CreateIngredientDTO create(CreateIngredientDTO createIngredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(createIngredientDTO.getName());
        ingredient.setCount(createIngredientDTO.getCount());
        ingredient.setBuyCost(createIngredientDTO.getBuyCost());
        ingredient.setSaleCost(createIngredientDTO.getSaleCost());
        ingredient.setNumberOfSales(createIngredientDTO.getNumberOfSales());
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        CreateIngredientDTO dto = new CreateIngredientDTO();
        dto.setId(savedIngredient.getId());
        dto.setName(savedIngredient.getName());
        dto.setCount(savedIngredient.getCount());
        dto.setBuyCost(savedIngredient.getBuyCost());
        dto.setSaleCost(savedIngredient.getSaleCost());
        dto.setNumberOfSales(savedIngredient.getNumberOfSales());
        return dto;
    }

    @Override
    public ReadIngredientDTO read(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        ReadIngredientDTO readIngredientDTO = new ReadIngredientDTO();
        readIngredientDTO.setId(ingredient.getId());
        readIngredientDTO.setName(ingredient.getName());
        readIngredientDTO.setCount(ingredient.getCount());
        readIngredientDTO.setBuyCost(ingredient.getBuyCost());
        readIngredientDTO.setSaleCost(ingredient.getSaleCost());
        readIngredientDTO.setNumberOfSales(ingredient.getNumberOfSales());
        return readIngredientDTO;
    }

    @Override
    @Transactional
    public UpdateIngredientDTO update(UpdateIngredientDTO updateIngredientDTO, Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        ingredient.setName(updateIngredientDTO.getName());
        ingredient.setCount(updateIngredientDTO.getCount());
        ingredient.setBuyCost(updateIngredientDTO.getBuyCost());
        ingredient.setSaleCost(updateIngredientDTO.getSaleCost());
        ingredient.setNumberOfSales(updateIngredientDTO.getNumberOfSales());
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        UpdateIngredientDTO dto = new UpdateIngredientDTO();
        dto.setId(savedIngredient.getId());
        dto.setName(savedIngredient.getName());
        dto.setCount(savedIngredient.getCount());
        dto.setBuyCost(savedIngredient.getBuyCost());
        dto.setSaleCost(savedIngredient.getSaleCost());
        dto.setNumberOfSales(savedIngredient.getNumberOfSales());
        return dto;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public List<GetAllIngredientDTO> getAll() {
        List<Ingredient> ing = ingredientRepository.findAll();
        return ing.stream().map(ingredient -> {
            GetAllIngredientDTO getAllIngredientDTO = new GetAllIngredientDTO();
            getAllIngredientDTO.setId(ingredient.getId());
            getAllIngredientDTO.setName(ingredient.getName());
            getAllIngredientDTO.setCount(ingredient.getCount());
            getAllIngredientDTO.setBuyCost(ingredient.getBuyCost());
            getAllIngredientDTO.setSaleCost(ingredient.getSaleCost());
            getAllIngredientDTO.setNumberOfSales(ingredient.getNumberOfSales());
            return getAllIngredientDTO;
        }).collect(Collectors.toList());
    }
    }
