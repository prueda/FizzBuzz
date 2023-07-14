package com.intraway.controller.resource;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FizzBuzzResponse {
    private Timestamp timestamp;
    private String code;
    private String description;
    private String list;
}

