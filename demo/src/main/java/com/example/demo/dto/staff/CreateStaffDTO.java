package com.example.demo.dto.staff;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CreateStaffDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private double weeklySalary;
}
