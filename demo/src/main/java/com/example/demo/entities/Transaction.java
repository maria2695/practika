package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "dateOfTransaction", nullable = false)
    private Date dateOfTransaction;
    @Column(name = "amountOfMoney", nullable = false)
    private Long amountOfMoney;
    @Column(name = "product", nullable = false)
    private String product;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
}
