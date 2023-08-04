package com.example.demo.dto.client;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CreateClientDto extends ClientInfoDto {
    @Max(value = 20)
    private String firstName;
    @Max(value = 20)
    private String lastName;
    @Min(value = 18, message = "No less then 18")
    @Max(value = 100, message = "No more than 100")
    private int age;
    @Min(value = 10, message = "No less then 10 symbols")
    private String login;
    @Min(value = 10, message = "No less then 10 symbols")
    private String password;
    @NotNull
    private double creditBalance;
}

