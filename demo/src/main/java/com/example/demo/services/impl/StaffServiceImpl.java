package com.example.demo.services.impl;

import com.example.demo.entities.Staff;
import com.example.demo.repository.StaffRepository;
import com.example.demo.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    @Override
    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff read(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public Staff update(Staff staff, Long id) {
        Staff excitedStaff = staffRepository.findById(id).orElse(null);
        if(excitedStaff != null){
            excitedStaff.setFirstName(staff.getFirstName());
            excitedStaff.setLastName(staff.getLastName());
            excitedStaff.setPosition(staff.getPosition());
            excitedStaff.setSalaryOfWeek(staff.getSalaryOfWeek());
        }
        return staffRepository.save(staff);
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }
}
