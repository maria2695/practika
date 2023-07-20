package com.example.demo.dto.drink;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CreateDrinkDTO {
    private Long id;
    private String name;
    private double price;
    private int presence;
}
