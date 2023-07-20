package com.example.demo.dto.ingredient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CreateIngredientDTO {
    private Long id;
    private String name;
    private double buyCost;
    private double saleCost;
    private int numberOfSales;
    private int count;
}
