package com.example.poc.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SavePersonV3UseCase {

    private final PersonV3Repository repository;


    public PersonV3Entity execute(PersonV3Entity entity) {
        return repository.save(entity);
    }
}
