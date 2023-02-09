package com.example.poc.v3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonV3Repository extends CrudRepository<PersonV3Entity, Integer> {

    PersonV3Entity findByLastName(String lastName);
}
