package com.example.demo.entities;

import com.example.demo.services.impl.BalanceServiceImpl;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Entity
@Table(name = "balances")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "balance_amount", nullable = false)
    private double balanceAmount;
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @Column(name = "last_transaction_date", nullable = false)
    private Date lastTransactionDate;




}
