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
    @Column
    private Date transactionDate;
    @Column
    private double transactionAmount;
    @ManyToOne
    @JoinColumn
    private Client client;
}
