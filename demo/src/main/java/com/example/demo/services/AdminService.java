package com.example.demo.services;

import com.example.demo.dto.admin.AdminInfoDto;
import com.example.demo.dto.staff.StaffInfoDto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

public interface AdminService {
    StaffInfoDto hireStaff(StaffInfoDto staffInfoDto);
    void fireStaff(Long id);
    double getBalance(Long id);
    void orderDrinksAndIngredients(Long clientId, Long drinkIngredient, Long ingredientId);
    void deactivateClientAccount(Long clientId);
}
