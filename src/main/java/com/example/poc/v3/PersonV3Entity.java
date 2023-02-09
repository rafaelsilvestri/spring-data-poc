package com.example.poc.v3;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("PERSON_V3")
public class PersonV3Entity implements Persistable<Long> {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;


    @Override
    public boolean isNew() {
        return id == null;
    }
}
