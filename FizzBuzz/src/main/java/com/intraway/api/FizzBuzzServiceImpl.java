package com.intraway.api;

import com.intraway.controller.resource.FizzBuzzResponse;
import com.intraway.domain.FizzBuzz;
import com.intraway.exceptions.BadRequest;
import com.intraway.repository.jdbc.FizzBuzzRepositoryImpl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private final FizzBuzzRepositoryImpl fizzBuzzRepository;

    @Autowired
    public FizzBuzzServiceImpl(FizzBuzzRepositoryImpl fizzBuzzRepository) {
        this.fizzBuzzRepository = fizzBuzzRepository;
    }
    
    @Override
    public FizzBuzzResponse getFizzBuzzList(int min, int max) throws BadRequest {
        if (min >= max) {
            throw new BadRequest("Los parámetros enviados son incorrectos");
        }
        StringBuilder result = new StringBuilder();
        String description = "";
        description = fizzBuzz(min, max, result, description);
        Timestamp timestamp = Timestamp.from(Instant.now());
        timestamp.setNanos(0);
        FizzBuzz fizzBuzz = new FizzBuzz(timestamp, "", description, result.toString());
        
        if (1 == fizzBuzzRepository.addFizzBuzz(fizzBuzz)) {
            Optional<FizzBuzz> fizzBuzzStored = fizzBuzzRepository.getFizzBuzz(fizzBuzz);
            
            return FizzBuzzResponse.builder()
                    .timestamp(fizzBuzzStored.get().getTimestamp())
                    .code(fizzBuzzStored.get().getCode())
                    .description(fizzBuzzStored.get().getDescription())
                    .list(fizzBuzzStored.get().getList()).build();
        }
        
        return new FizzBuzzResponse();
    }

    private static String fizzBuzz(int min, int max, StringBuilder result, String description) {
        for (int i = min; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.append("FizzBuzz");
                description = "se encontraron múltiplos de 3 y de 5";
            } else if (i % 3 == 0) {
                result.append("Fizz");
                description = "se encontraron múltiplos de 3";
            } else if (i % 5 == 0) {
                result.append("Buzz");
                description = "se encontraron múltiplos de 5";
            } else {
                result.append(i);
            }

            if (i != max) {
                result.append(",");
            }
        }
        return description;
    }

}
