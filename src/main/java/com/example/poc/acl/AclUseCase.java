package com.example.poc.acl;

import com.example.poc.v2.PersonV2Entity;
import com.example.poc.v2.SavePersonV2UseCase;
import com.example.poc.v3.PersonV3Entity;
import com.example.poc.v3.SavePersonV3UseCase;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Data
@Component
public class AclUseCase {

    private final SavePersonV2UseCase useCaseV2;
    private final SavePersonV3UseCase useCaseV3;

    @Transactional
    public PersonV2Entity executeV2ToV3(PersonV2Entity entityV2) {
        PersonV3Entity entityV3 = new PersonV3Entity();
        entityV3.setFirstName(entityV2.getFirstName());
        entityV3.setLastName(entityV2.getLastName());
        entityV3.setEmail("default@foo.bar");
        useCaseV3.execute(entityV3);

        // Injecting exceptions to proof the rollback in both repositories (JPA and JDBC)
        /*if (1 == 1) {
            throw new RuntimeException("Unexpected error before save v2!");
        }*/
        entityV2 = useCaseV2.execute(entityV2);
        /*if (1 == 1) {
            throw new RuntimeException("Unexpected error after save v2!");
        }*/

        return entityV2;
    }

    @Transactional
    public PersonV3Entity executeV3ToV2(PersonV3Entity entityV3) {
        PersonV2Entity entityV2 = new PersonV2Entity();
        entityV2.setFirstName(entityV3.getFirstName());
        entityV2.setLastName(entityV3.getLastName());
        useCaseV2.execute(entityV2);
        // Injecting exceptions to proof the rollback in both repositories (JPA and JDBC)
        /*if (1 == 1) {
            throw new RuntimeException("Unexpected error before save v2!");
        }*/

        entityV3 = useCaseV3.execute(entityV3);
        /*if (1 == 1) {
            throw new RuntimeException("Unexpected error after save v2!");
        }*/
        return entityV3;
    }
}
