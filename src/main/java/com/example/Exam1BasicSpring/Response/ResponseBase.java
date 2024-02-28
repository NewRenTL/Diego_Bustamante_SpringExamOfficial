package com.example.Exam1BasicSpring.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Optional;


@AllArgsConstructor
@Getter
@Setter
public class ResponseBase {
    private int codigo;
    private String message;
    private boolean success;
    private Optional data;
}
