package com.example.demo.services;

import com.example.demo.entities.Ingredient;
import com.example.demo.entities.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {
    Staff create(Staff staff);
    Staff getStaffById(Long id);
    Staff update(Staff staff);
    void delete(Long id);
    List<Staff> getAll();
}
