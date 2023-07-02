package com.example.demo.services.impl;

import com.example.demo.entities.Staff;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.StaffRepository;
import com.example.demo.services.StaffService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff create(Staff staff) {
        if(staff != null){
            return staffRepository.save(staff);
        }
        throw new NullEntityReferenceException("Cannot be 'null");
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Staff with id" + id + "not found")
        );
    }

    @Override
    public Staff update(Staff staff) {
        if(staff != null){
            getStaffById(staff.getId());
            return staffRepository.save(staff);
        }
        throw new NullEntityReferenceException("Cannot be 'null");
    }

    @Override
    public void delete(Long id) {
        Staff staff = getStaffById(id);
        staffRepository.delete(staff);
    }

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }
}
