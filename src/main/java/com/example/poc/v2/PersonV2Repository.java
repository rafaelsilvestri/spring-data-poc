package com.example.poc.v2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonV2Repository extends CrudRepository<PersonV2Entity, Integer> {

    PersonV2Entity findByLastName(String lastName);
}
