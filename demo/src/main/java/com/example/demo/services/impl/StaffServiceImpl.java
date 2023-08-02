package com.example.demo.services.impl;

import com.example.demo.dto.staff.StaffInfoDto;
import com.example.demo.entities.Staff;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repository.StaffRepository;
import com.example.demo.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    private Staff mapToStaff(Staff staff, StaffInfoDto staffInfoDto){
        staff.setFirstName(staffInfoDto.getFirstName());
        staff.setLastName(staffInfoDto.getLastName());
        staff.setPosition(staffInfoDto.getPosition());
        staff.setWeeklySalary(staff.getWeeklySalary());
        return staffRepository.save(staff);
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
    public StaffInfoDto create(Staff staff, StaffInfoDto staffInfoDto) {
        Staff savedStaff = mapToStaff(staff,staffInfoDto);
        return mapToStaffDto(savedStaff);
    }

    @Override
    @Transactional(readOnly = true)
    public StaffInfoDto read(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
       return mapToStaffDto(staff);
    }

    @Override
    @Transactional
    public StaffInfoDto update(StaffInfoDto updateStaffDto, Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        var updated = staffRepository.save(mapToStaff(staff, updateStaffDto));
        return mapToStaffDto(updated);
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StaffInfoDto> getAll() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream()
                .map(this::mapToStaffDto)
                .collect(Collectors.toList());
    }
}

