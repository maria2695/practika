package com.example.demo.dto.pizza;

import com.example.demo.entities.Ingredient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class CreatePizzaDTO {
    private Long id;
    private String name;
    private List<Ingredient> ingredients;
}
