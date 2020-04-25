package micronaut.aws.graphql.jpa;

import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.annotation.*;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>  {}