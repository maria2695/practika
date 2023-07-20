package com.example.demo.services;

import com.example.demo.dto.staff.CreateStaffDTO;
import com.example.demo.dto.staff.GetAllStaffDTO;
import com.example.demo.dto.staff.ReadStaffDTO;
import com.example.demo.dto.staff.UpdateStaffDTO;
import java.util.List;

public interface StaffService {
    CreateStaffDTO create(CreateStaffDTO staff);
    ReadStaffDTO read(Long id);
    UpdateStaffDTO update(UpdateStaffDTO staff, Long id);
    void delete(Long id);
    List<GetAllStaffDTO> getAll();
}
