package com.example.demo.services;

import com.example.demo.entities.Drink;
import com.example.demo.entities.Staff;

import java.util.List;

public interface StaffService {
    Staff create(Staff staff);
    Staff read(Long id);
    Staff update(Staff staff, Long id);
    void delete(Long id);
    List<Staff> getAll();
}
