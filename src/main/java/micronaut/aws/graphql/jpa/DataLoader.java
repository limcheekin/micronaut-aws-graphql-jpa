package micronaut.aws.graphql.jpa;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Singleton;

/**
 * REF: https://mrhaki.blogspot.com/2018/09/micronaut-mastery-running-code-on.html 
 */
@Singleton
@Requires(notEnv = Environment.TEST) // Don't load data in tests.
public class DataLoader implements ApplicationEventListener<ServiceStartedEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);
    private final PersonRepository repository;

    public DataLoader(final PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(final ServiceStartedEvent event) {
        LOG.info("Loading data at startup...");
        repository.save(new Person("Chee Kin", "Lim", "limcheekin@xyz.com"));
        repository.save(new Person("Chee K.", "Lim", "cklim@xyz.com"));
        repository.save(new Person("William", "Chang", "chang.william@xyz.com"));
        LOG.info("Data loaded.");
    }
}