package com.example.demo.dto.ingredient;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class IngredientInfoDto {
    @NotEmpty
    private String name;
    @NotNull
    private double buyCost;
    @NotNull
    private double saleCost;
    @NotNull
    private int numberOfSales;
    @NotNull
    private int count;
}
