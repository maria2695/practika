package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ClientRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
}
