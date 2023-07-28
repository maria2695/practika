package com.example.demo.services.impl;

import com.example.demo.dto.ingredient.IngredientInfoDto;
import com.example.demo.entities.Ingredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.services.IngredientService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    private Ingredient mapToIngredient(IngredientInfoDto ingredientInfoDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientInfoDto.getName());
        ingredient.setCount(ingredientInfoDto.getCount());
        ingredient.setBuyCost(ingredientInfoDto.getBuyCost());
        ingredient.setSaleCost(ingredientInfoDto.getSaleCost());
        ingredient.setNumberOfSales(ingredientInfoDto.getNumberOfSales());
        return ingredientRepository.save(ingredient);
    }

    private IngredientInfoDto mapToIngredientDto(Ingredient ingredient){
        IngredientInfoDto dto = new IngredientInfoDto();
        dto.setName(ingredient.getName());
        dto.setCount(ingredient.getCount());
        dto.setBuyCost(ingredient.getBuyCost());
        dto.setSaleCost(ingredient.getSaleCost());
        dto.setNumberOfSales(ingredient.getNumberOfSales());
        return dto;
    }

    @Override
    @Transactional
    public IngredientInfoDto create(IngredientInfoDto createIngredientDTO) {
        if(createIngredientDTO != null){
            Ingredient savedIngredient = mapToIngredient(createIngredientDTO);
            return mapToIngredientDto(savedIngredient);
        }
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public IngredientInfoDto read(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        return mapToIngredientDto(ingredient);
    }

    @Override
    @Transactional
    public IngredientInfoDto update(IngredientInfoDto updateIngredientDTO, Long id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        mapToIngredient(updateIngredientDTO);
        return mapToIngredientDto(ingredient);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IngredientInfoDto> getAll() {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        return ingredientList.stream()
                .map(this::mapToIngredientDto)
                .collect(Collectors.toList());
    }
}
