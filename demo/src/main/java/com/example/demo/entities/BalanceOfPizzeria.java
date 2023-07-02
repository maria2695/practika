package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "pizza_balance")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceOfPizzeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "closing_time", nullable = false)
    private LocalTime closingTime;
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;
}
