package com.example.demo.services;

import com.example.demo.dto.staff.StaffInfoDto;
import com.example.demo.entities.Staff;

import java.util.List;

public interface StaffService {
    StaffInfoDto create(Staff staff, StaffInfoDto staffInfoDto);
    StaffInfoDto read(Long id);
    StaffInfoDto update(StaffInfoDto updateStaffDto, Long id);
    void delete(Long id);
    List<StaffInfoDto> getAll();
}
