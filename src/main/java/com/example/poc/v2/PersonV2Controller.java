package com.example.poc.v2;

import com.example.poc.acl.AclUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PersonV2Controller {

    private final SavePersonV2UseCase useCase;
    private final AclUseCase aclUseCase;
    private final PersonV2Repository repository;

    @GetMapping(value = "/v2/person")
    public ResponseEntity<Iterable<PersonV2Entity>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping(value = "/v2/person")
    public ResponseEntity<PersonV2Entity> post(@RequestBody final PersonV2Entity personV2Entity) {
        return ResponseEntity.ok(useCase.execute(personV2Entity));
    }

    @PostMapping(value = "/v2/person/acl")
    public ResponseEntity<PersonV2Entity> postAcl(@RequestBody final PersonV2Entity personV2Entity) {
        return ResponseEntity.ok(aclUseCase.executeV2ToV3(personV2Entity));
    }
}