package com.example.demo.services.impl;

import com.example.demo.dto.staff.CreateStaffDTO;
import com.example.demo.dto.staff.GetAllStaffDTO;
import com.example.demo.dto.staff.ReadStaffDTO;
import com.example.demo.dto.staff.UpdateStaffDTO;
import com.example.demo.entities.Staff;
import com.example.demo.repository.StaffRepository;
import com.example.demo.services.StaffService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;


    @Override
    @Transactional
    public CreateStaffDTO create(CreateStaffDTO createStaffDTO) {
        Staff staff = new Staff();
        staff.setFirstName(createStaffDTO.getFirstName());
        staff.setLastName(createStaffDTO.getLastName());
        staff.setPosition(createStaffDTO.getPosition());
        staff.setWeeklySalary(staff.getWeeklySalary());
        Staff savedStaff = staffRepository.save(staff);
        CreateStaffDTO dto = new CreateStaffDTO();
        dto.setId(savedStaff.getId());
        dto.setFirstName(savedStaff.getFirstName());
        dto.setLastName(savedStaff.getLastName());
        dto.setPosition(savedStaff.getPosition());
        dto.setWeeklySalary((savedStaff.getWeeklySalary()));
        return dto;
    }

    @Override
    public ReadStaffDTO read(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        ReadStaffDTO readStaffDTO = new ReadStaffDTO();
        readStaffDTO.setId(staff.getId());
        readStaffDTO.setFirstName(staff.getFirstName());
        readStaffDTO.setLastName(staff.getLastName());
        readStaffDTO.setPosition(staff.getPosition());
        readStaffDTO.setWeeklySalary(staff.getWeeklySalary());
        return readStaffDTO;
    }

    @Override
    @Transactional
    public UpdateStaffDTO update(UpdateStaffDTO updateStaffDTO, Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        staff.setFirstName(updateStaffDTO.getFirstName());
        staff.setLastName(updateStaffDTO.getLastName());
        staff.setPosition(updateStaffDTO.getPosition());
        staff.setWeeklySalary(updateStaffDTO.getWeeklySalary());
        Staff savedStaff = staffRepository.save(staff);
        UpdateStaffDTO dto = new UpdateStaffDTO();
        dto.setId(savedStaff.getId());
        dto.setFirstName(savedStaff.getFirstName());
        dto.setLastName(savedStaff.getLastName());
        dto.setPosition(savedStaff.getPosition());
        dto.setWeeklySalary(savedStaff.getWeeklySalary());
        return dto;
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public List<GetAllStaffDTO> getAll() {
        List<Staff> staff1 = staffRepository.findAll();
        return staff1.stream().map(staff -> {
            GetAllStaffDTO getAllStaffDTO = new GetAllStaffDTO();
            getAllStaffDTO.setId(staff.getId());
            getAllStaffDTO.setFirstName(staff.getFirstName());
            getAllStaffDTO.setLastName(staff.getLastName());
            getAllStaffDTO.setPosition(staff.getPosition());
            getAllStaffDTO.setWeeklySalary(staff.getWeeklySalary());
            return getAllStaffDTO;
                }).collect(Collectors.toList());
    }
}
