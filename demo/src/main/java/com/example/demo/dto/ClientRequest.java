package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ClientRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String login;


}
