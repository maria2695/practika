package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ingredients")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "acquisition_cost", nullable = false)
    private double acquisitionCost;
    @Column(name = "retail_price ", nullable = false)
    private double retailPrice;
    @Column(name = "number_of_sales ", nullable = false)
    private int numberOfSales;
    @Column(name = "count", nullable = false)
    private int count;
}
