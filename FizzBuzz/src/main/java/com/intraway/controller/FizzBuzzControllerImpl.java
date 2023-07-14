package com.intraway.controller;

import com.intraway.api.FizzBuzzServiceImpl;
import com.intraway.controller.resource.FizzBuzzResponse;
import com.intraway.exceptions.BadRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/intraway/api/fizzbuzz")
public class FizzBuzzControllerImpl implements FizzBuzzController {
    private FizzBuzzServiceImpl fizzBuzzService;

    public FizzBuzzControllerImpl(FizzBuzzServiceImpl fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @Override
    @GetMapping("/{min}/{max}")
    public ResponseEntity<FizzBuzzResponse> getFizzBuzzList(@PathVariable int min, @PathVariable int max) throws BadRequest {
        return ResponseEntity.ok(fizzBuzzService.getFizzBuzzList(min, max));
    }
}

