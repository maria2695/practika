package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="ingredients")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "acquisitionCost", nullable = false)
    private double acquisitionCost;
    @Column(name = "retailPrice", nullable = false)
    private double retailPrice;
    @Column(name = "countOfSales", nullable = false)
    private int countOfSales;
    @Column(name = "countOfIngredients", nullable = false)
    private int countOfIngredients;
    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

}
