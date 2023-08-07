package com.example.demo.services.impl;

import com.example.demo.dto.staff.StaffInfoDto;
import com.example.demo.entities.Staff;
import com.example.demo.exception.NullEntityReferenceException;
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
    public StaffInfoDto create(StaffInfoDto staffInfoDto) {
        if(staffInfoDto != null){
            var savedStaff = staffRepository.save(mapDtoToStaff(staffInfoDto));
            return mapToStaffDto(savedStaff);
        }
        throw new NullEntityReferenceException("Cannot be null");
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
        var staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        var updated = staffRepository.save(mapDtoToStaff(updateStaffDto));
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

