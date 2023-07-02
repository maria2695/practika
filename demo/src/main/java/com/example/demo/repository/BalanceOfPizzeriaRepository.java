package com.example.demo.repository;


import com.example.demo.entities.BalanceOfPizzeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceOfPizzeriaRepository extends JpaRepository <BalanceOfPizzeria, Long> {
}
