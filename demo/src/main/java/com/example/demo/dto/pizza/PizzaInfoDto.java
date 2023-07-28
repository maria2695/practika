package com.example.demo.dto.pizza;

import com.example.demo.entities.Ingredient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class PizzaInfoDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private List<Ingredient> ingredients;
}
