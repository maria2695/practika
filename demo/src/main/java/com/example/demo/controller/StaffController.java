package com.example.demo.controller;


import com.example.demo.entities.Staff;
import com.example.demo.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;
    @PostMapping("/create")
    public Staff create(@RequestBody Staff staff){
        return staffService.create(staff);
    }

    @GetMapping("/{id}")
    public Staff getByTransactionId(@PathVariable Long id){
        return staffService.getStaffById(id);
    }

    @PutMapping("/{id}")
    public Staff update(@PathVariable Long id, @RequestBody Staff staff){
        staff.setId(id);
        return staffService.update(staff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        staffService.delete(id);
    }

    @GetMapping
    public List<Staff> getAll(){
        return staffService.getAll();
    }

}
