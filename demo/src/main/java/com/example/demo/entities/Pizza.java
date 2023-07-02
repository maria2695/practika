package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="pizzas")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nameOfPizza", nullable = false)
    private String nameOfPizza;
    @OneToMany(mappedBy = "listOfIngredients")
    private List<Ingredient> listOfIngredients;

}
