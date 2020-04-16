package ch.axa.meatbackend.config;

import ch.axa.meatbackend.graphql.resolver.Mutation;
import ch.axa.meatbackend.graphql.resolver.Query;
import ch.axa.meatbackend.mongo.repository.NameRepository;
import ch.axa.meatbackend.service.NameService;
import ch.axa.meatbackend.service.NameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IoCConfig {

    @Autowired
    private NameRepository nameRepository;

    @Bean
    public NameService nameService() {
        return new NameServiceImpl(nameRepository);
    }

    @Bean
    public Query queryResolver() {
        return new Query(nameService());
    }

    @Bean
    public Mutation mutationResolver() {
        return new Mutation(nameService());
    }

}
