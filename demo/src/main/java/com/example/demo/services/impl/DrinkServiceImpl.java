package com.example.demo.services.impl;

import com.example.demo.dto.drink.DrinkInfoDto;
import com.example.demo.entities.Drink;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.services.DrinkService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    private Drink mapToDrink(DrinkInfoDto drinkInfoDto){
        Drink drink = new Drink();
        drink.setName(drinkInfoDto.getName());
        drink.setPrice(drinkInfoDto.getPrice());
        drink.setPresence(drinkInfoDto.getPresence());
        return drinkRepository.save(drink);
    }

    private DrinkInfoDto mapToDrinkDto(Drink drink){
        DrinkInfoDto dto = new DrinkInfoDto();
        dto.setName(drink.getName());
        dto.setPrice(drink.getPrice());
        dto.setPresence(drink.getPresence());
        return dto;
    }

    @Override
    @Transactional
    public DrinkInfoDto create(DrinkInfoDto createDrinkDTO) {
       if(createDrinkDTO != null){
           Drink savedDrink = mapToDrink(createDrinkDTO);
           return mapToDrinkDto(savedDrink);
       }
       return null;
    }

    @Override
    @Transactional(readOnly = true)
    public DrinkInfoDto read(Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drink not found"));
       return mapToDrinkDto(drink);
    }

    @Override
    @Transactional
    public DrinkInfoDto update(DrinkInfoDto updateDrinkDto, Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drink not found"));
          mapToDrink(updateDrinkDto);
          return mapToDrinkDto(drink);
    }

    @Override
    public void delete(Long id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public List<DrinkInfoDto> getAll() {
        List<Drink> drinkList = drinkRepository.findAll();
        return drinkList.stream()
                .map(this::mapToDrinkDto)
                .collect(Collectors.toList());
    }
}
