package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "staff")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "position", nullable = false)
    private String position;
    @Column(name = "salary_of_week", nullable = false)
    private double salaryOfWeek;
}
