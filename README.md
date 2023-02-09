# Spring Data PoC
Proofing some flavors of Spring Data and how they work together.

## Getting Started
```bash
$ ./gradlew bootRun
```

## Testing

There is a Postman collection [here](Spring%20Data%20PoC.postman_collection.json) to easily try it! 

### Use Case
The proposal of this PoC is to proof the following bullet points:
* Could Spring Data JPA and Spring Data JDBC live in the same project without conflicts or problems?
* Could both being used without problems?
* Could both interact with each other without problems?
* Could both share the same connection and transaction state so the interaction between both could be "transactional" and "atomic"?

### Results
YES! We were able to answer them all with good results.

Spring Rocks!!!


# References
https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/
https://www.jpa-buddy.com/blog/spring-data-jpa-to-spring-data-jdbc-a-smooth-ride/