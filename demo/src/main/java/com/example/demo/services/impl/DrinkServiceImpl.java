package com.example.demo.services.impl;

import com.example.demo.dto.drink.CreateDrinkDTO;
import com.example.demo.dto.drink.GetAllDrinksDTO;
import com.example.demo.dto.drink.ReadDrinkDTO;
import com.example.demo.dto.drink.UpdateDrinkDTO;
import com.example.demo.entities.Drink;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.services.DrinkService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    @Override
    @Transactional
    public CreateDrinkDTO create(CreateDrinkDTO createDrinkDTO) {
        Drink drink = new Drink();
        drink.setName(createDrinkDTO.getName());
        drink.setPrice(createDrinkDTO.getPrice());
        drink.setPresence(createDrinkDTO.getPresence());
        Drink savedDrink = drinkRepository.save(drink);
        CreateDrinkDTO dto = new CreateDrinkDTO();
        dto.setId(savedDrink.getId());
        dto.setName(savedDrink.getName());
        dto.setPrice(savedDrink.getPrice());
        dto.setPresence(savedDrink.getPresence());
        return dto;
    }

    @Override
    public ReadDrinkDTO read(Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drink not found"));
        ReadDrinkDTO readDrinkDTO = new ReadDrinkDTO();
        readDrinkDTO.setId(drink.getId());
        readDrinkDTO.setName(drink.getName());
        readDrinkDTO.setPrice(drink.getPrice());
        readDrinkDTO.setPresence(drink.getPresence());
        return readDrinkDTO;
    }

    @Override
    @Transactional
    public UpdateDrinkDTO update(UpdateDrinkDTO updateDrinkDTO, Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drink not found"));
        drink.setName(updateDrinkDTO.getName());
        drink.setPrice(updateDrinkDTO.getPrice());
        drink.setPresence(updateDrinkDTO.getPresence());
        UpdateDrinkDTO dto = new UpdateDrinkDTO();
        Drink savedDrink = drinkRepository.save(drink);
        dto.setId(savedDrink.getId());
        dto.setName(savedDrink.getName());
        dto.setPrice(savedDrink.getPrice());
        dto.setPresence(savedDrink.getPresence());
        return dto;
    }

    @Override
    public void delete(Long id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public List<GetAllDrinksDTO> getAll() {
        List<Drink> dr = drinkRepository.findAll();
        return dr.stream().map(drink -> {
            GetAllDrinksDTO getAllDrinksDTO = new GetAllDrinksDTO();
            getAllDrinksDTO.setId(drink.getId());
            getAllDrinksDTO.setName(drink.getName());
            getAllDrinksDTO.setPrice(drink.getPrice());
            getAllDrinksDTO.setPresence(drink.getPresence());
            return getAllDrinksDTO;
        }).collect(Collectors.toList());
    }
}
