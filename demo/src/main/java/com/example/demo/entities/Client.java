package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="clients")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "creditBalance", nullable = false)
    private double creditBalance;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @OneToMany (fetch = FetchType.LAZY)
    private List<Transaction> listOfTransactions;

}
