package ch.axa.meatbackend.cofig;

import ch.axa.meatbackend.mongo.repository.NameRepository;
import ch.axa.meatbackend.service.NameService;
import ch.axa.meatbackend.service.NameServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestNameConfig {

    @Bean
    public NameService nameService(){
        return new NameServiceImpl(nameRepository());
    }

    @Bean
    public NameRepository nameRepository(){return Mockito.mock(NameRepository.class);}

}
