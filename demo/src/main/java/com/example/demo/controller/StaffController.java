package com.example.demo.controller;

import com.example.demo.dto.staff.StaffInfoDto;
import com.example.demo.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/staff")
public class StaffController {

    private final StaffService staffService;

    @PostMapping
    public StaffInfoDto createStaff(@RequestBody StaffInfoDto createStaffDTO){
        return staffService.create(createStaffDTO);
    }
    @GetMapping
    public StaffInfoDto readStaff(@RequestParam Long id){
        return staffService.read(id);
    }
    @PutMapping
    public StaffInfoDto updateStaff(@RequestBody StaffInfoDto updateStaffDTO, @RequestParam Long id){
        return staffService.update(updateStaffDTO, id);
    }
    @DeleteMapping
    public void deleteStaff(@RequestParam Long id){
        staffService.delete(id);
    }
    @GetMapping("/list")
    public List<StaffInfoDto> staffList(){
        return staffService.getAll();
    }
}
