package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Builder
@ToString
public class ApiResponse<T> {
    String message;
    Integer status;
    List<String> errors;
    T data;
}
