package com.intraway.api;

import com.intraway.controller.resource.FizzBuzzResponse;
import com.intraway.exceptions.BadRequest;

public interface FizzBuzzService {
    FizzBuzzResponse getFizzBuzzList(int min, int max) throws BadRequest;
}
