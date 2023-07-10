package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Entity
@Table(name = "transactions")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;
    @Column(name = "transaction_amount", nullable = false)
    private double transactionAmount;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "drink_id", nullable = false)
    private Drink drink;
    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;




}
