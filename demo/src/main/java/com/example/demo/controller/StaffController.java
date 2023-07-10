package com.example.demo.controller;

import com.example.demo.entities.Staff;
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
    public Staff createStaff(@RequestBody Staff staff){
        return staffService.create(staff);
    }
    @GetMapping("/{id}")
    public Staff readStaff(@PathVariable Long id){
        return staffService.read(id);
    }
    @PutMapping("/{id}")
    public Staff updateStaff(@RequestBody Staff staff, @PathVariable Long id){
        return staffService.update(staff, id);
    }
    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id){
        staffService.delete(id);
    }
    @GetMapping("/list")
    public List<Staff> staffList(){
        return staffService.getAll();
    }

}
