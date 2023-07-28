package com.example.demo.dto.staff;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class StaffInfoDto {
    @Max(value = 20)
    private String firstName;
    @Max(value = 20)
    private String lastName;
    @NotEmpty
    private String position;
    @NotNull
    private double weeklySalary;
}
