package com.example.poc.v3;

import com.example.poc.acl.AclUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PersonV3Controller {

    private final SavePersonV3UseCase useCase;
    private final AclUseCase aclUseCase;
    private final PersonV3Repository repository;


    @GetMapping(value = "/v3/person")
    public ResponseEntity<Iterable<PersonV3Entity>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping(value = "/v3/person")
    public ResponseEntity<PersonV3Entity> post(@RequestBody final PersonV3Entity personV3Entity) {
        return ResponseEntity.ok(useCase.execute(personV3Entity));
    }

    @PostMapping(value = "/v3/person/acl")
    public ResponseEntity<PersonV3Entity> postAcl(@RequestBody final PersonV3Entity personV3Entity) {
        return ResponseEntity.ok(aclUseCase.executeV3ToV2(personV3Entity));
    }
}