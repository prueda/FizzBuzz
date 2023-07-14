package com.intraway.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FizzBuzz {
    private Timestamp timestamp;
    
    private String code;
    
    private String description;
    private String list;
}

