package micronaut.aws.graphql.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.http.annotation.*;

@Controller("/")
public class PersonController {
    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);
    private PersonRepository repository;

    @Get("/ping")
    public String index() {
        return "{\"pong\":true, \"graal\": true}";
    }

    @Get("/count")
    public String count() {
        return "{\"count\":" + repository.count() + "}";
    }

}
