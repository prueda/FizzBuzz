package com.intraway.repository.jdbc;

import com.intraway.domain.FizzBuzz;

import java.util.Optional;

public interface FizzBuzzRepository {
    int addFizzBuzz(FizzBuzz fizzBuzz);

    Optional<FizzBuzz> getFizzBuzz(FizzBuzz fizzBuzz);
}
