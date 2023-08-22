package com.example.demo.services.impl;

import com.example.demo.dto.admin.AdminInfoDto;
import com.example.demo.dto.staff.StaffInfoDto;
import com.example.demo.dto.transaction.TransactionInfoDto;
import com.example.demo.entities.Administrator;
import com.example.demo.entities.Staff;
import com.example.demo.entities.Transaction;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.*;
import com.example.demo.services.AdminService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final StaffRepository staffRepository;
    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;
    private final DrinkRepository drinkRepository;
    private final IngredientRepository ingredientRepository;
    private final BalanceRepository balanceRepository;

    private Staff mapDtoToStaff(StaffInfoDto staffInfoDto){
        var staff = new Staff();
        staff.setFirstName(staffInfoDto.getFirstName());
        staff.setLastName(staffInfoDto.getLastName());
        staff.setPosition(staffInfoDto.getPosition());
        staff.setWeeklySalary(staff.getWeeklySalary());
        return staff;
    }

    private StaffInfoDto mapToStaffDto(Staff staff){
        StaffInfoDto dto = new StaffInfoDto();
        dto.setFirstName(staff.getFirstName());
        dto.setLastName(staff.getLastName());
        dto.setPosition(staff.getPosition());
        dto.setWeeklySalary((staff.getWeeklySalary()));
        return dto;
    }

    @Override
    @Transactional
    public StaffInfoDto hireStaff(StaffInfoDto staffInfoDto) {
        if(staffInfoDto != null){
            var savedStaff = staffRepository.save(mapDtoToStaff(staffInfoDto));
            return mapToStaffDto(savedStaff);
        }
        throw new NullEntityReferenceException("Cannot be null");
    }

    @Override
    public void fireStaff(Long id) {
        var staff = staffRepository.findById(id).orElseThrow( () -> new NullEntityReferenceException("Not found"));
        staffRepository.delete(staff);

    }

    @Override
    public double getBalance(Long id) {
        var admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrator not found"));
        return admin.getBalance();
    }

    @Override
    public void orderDrinksAndIngredients(Long clientId, Long drinkId, Long ingredientId) {
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        var drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new RuntimeException("Drink not found"));
        var ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        double totalCost = drink.getPrice() + ingredient.getSaleCost();
        var balance = balanceRepository.findById(client.getId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        if(balance.getBalanceAmount() < totalCost){
            throw new NullEntityReferenceException("Insufficient balance for the order");
        }

        balance.setBalanceAmount(balance.getBalanceAmount() - totalCost);
        balance.setLastTransactionDate(new Date());
        balanceRepository.save(balance);

        drink.setPresence(drink.getPresence() - 1);
        ingredient.setNumberOfSales(ingredient.getNumberOfSales() + 1);
        ingredientRepository.save(ingredient);
        drinkRepository.save(drink);
    }

    @Override
    public void deactivateClientAccount(Long clientId) {
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        if(client != null){
            client.setActive(false);
            clientRepository.save(client);
        }
    }
}


