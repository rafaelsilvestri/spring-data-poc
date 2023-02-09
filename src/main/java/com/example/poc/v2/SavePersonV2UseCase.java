package com.example.poc.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SavePersonV2UseCase {

    private final PersonV2Repository repository;


    public PersonV2Entity execute(PersonV2Entity entity) {
        return repository.save(entity);
    }
}
