package com.example.demo.controller;

import com.example.demo.dto.staff.CreateStaffDTO;
import com.example.demo.dto.staff.GetAllStaffDTO;
import com.example.demo.dto.staff.ReadStaffDTO;
import com.example.demo.dto.staff.UpdateStaffDTO;
import com.example.demo.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/staff")
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/create")
    public CreateStaffDTO createStaff(@RequestBody CreateStaffDTO createStaffDTO){
        return staffService.create(createStaffDTO);
    }
    @GetMapping("/{id}")
    public ReadStaffDTO readStaff(@RequestParam Long id){
        return staffService.read(id);
    }
    @PutMapping("/{id}")
    public UpdateStaffDTO updateStaff(@RequestBody UpdateStaffDTO updateStaffDTO, @RequestParam Long id){
        return staffService.update(updateStaffDTO, id);
    }
    @DeleteMapping("/{id}")
    public void deleteStaff(@RequestParam Long id){
        staffService.delete(id);
    }
    @GetMapping("/list")
    public List<GetAllStaffDTO> staffList(){
        return staffService.getAll();
    }
}
