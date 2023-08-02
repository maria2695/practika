package com.example.demo.dto.drink;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class DrinkInfoDto {
    @NotEmpty
    private String name;
    @NotNull
    private double price;
    @NotNull
    private int presence;
}
