package ch.axa.meatbackend;

import ch.axa.meatbackend.mongo.model.Name;
import ch.axa.meatbackend.mongo.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ch.axa.meatbackend.config",
				"ch.axa.meatbackend.graphql",
				"ch.axa.meatbackend.rest"})
public class MeatBackendApplication implements CommandLineRunner {

	@Autowired
	private NameRepository nameRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeatBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 //nameRepository.save(new Name("Romina", "Ferrario"));

		System.out.println("Names found with findAll()");
		System.out.println("---------------------------------");
		nameRepository.findAll().forEach(System.out::println);
	}

}
