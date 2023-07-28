package com.example.demo.services;

import com.example.demo.dto.staff.StaffInfoDto;

import java.util.List;

public interface StaffService {
    StaffInfoDto create(StaffInfoDto staff);
    StaffInfoDto read(Long id);
    StaffInfoDto update(StaffInfoDto staff, Long id);
    void delete(Long id);
    List<StaffInfoDto> getAll();
}
