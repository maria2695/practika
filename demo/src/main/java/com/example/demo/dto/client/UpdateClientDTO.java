package com.example.demo.dto.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UpdateClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String login;
    public String password;
    private double creditBalance;
}
