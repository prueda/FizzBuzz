package com.intraway.controller;

import com.intraway.controller.resource.FizzBuzzResponse;
import com.intraway.exceptions.BadRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface FizzBuzzController {
    @GetMapping("/{min}/{max}")
    ResponseEntity<FizzBuzzResponse> getFizzBuzzList(@PathVariable int min, @PathVariable int max) throws BadRequest;
}
