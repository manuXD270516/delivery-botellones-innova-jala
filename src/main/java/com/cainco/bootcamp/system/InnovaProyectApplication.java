package com.cainco.bootcamp.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@SpringBootApplication(/*exclude = {HibernateJpaAutoConfiguration.class}*/)
public class InnovaProyectApplication implements ApplicationRunner {
/*

	private static final Logger log = LoggerFactory.getLogger(InnovaProyectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InnovaProyectApplication.class);
	}

	@Bean
	public CommandLineRunner demo(PersonaRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Persona("Jack", "Bauer","777777"));
			repository.save(new Persona("Chloe", "O'Brian", "111111"));
			repository.save(new Persona("Kim", "Bauer", "31313"));
			repository.save(new Persona("David", "Palmer", "3131"));
			repository.save(new Persona("Michelle", "Dessler", "44822"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Persona persona : repository.findAll()) {
				log.info(persona.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Persona> persona = repository.findById(1L);

			log.info("Persona found with findById(1L):");
			log.info("--------------------------------");
			log.info(persona.get().toString());
			log.info("");

			log.info("");
		};
	}
*/


	public static void main(String[] args) {
		SpringApplication.run(InnovaProyectApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*Persona p = new Persona();
		p.setNombres("manuel");
		p.setApellidos("saavedra");
		p.setTelefono("785824");
		personaRepository.save(p);*/
	}



}
