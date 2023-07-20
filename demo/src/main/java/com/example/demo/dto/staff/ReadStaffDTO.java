package com.example.demo.dto.staff;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ReadStaffDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private double weeklySalary;
}
