package com.cainco.bootcamp.system;

import com.cainco.bootcamp.system.dao.IClienteDao;
import com.cainco.bootcamp.system.dao.IProductoDao;
import com.cainco.bootcamp.system.dao.IRepartidorDao;
import com.cainco.bootcamp.system.dao.IZonaDao;
import com.cainco.bootcamp.system.entity.Cliente;
import com.cainco.bootcamp.system.entity.Producto;
import com.cainco.bootcamp.system.entity.Repartidor;
import com.cainco.bootcamp.system.entity.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaRepositories
@SpringBootApplication(/*exclude = {HibernateJpaAutoConfiguration.class}*/)
public class InnovaProyectApplication implements ApplicationRunner {

	@Autowired
	private IClienteDao clienteDao;
	@Autowired
	private IProductoDao productoDao;
	@Autowired
	private IRepartidorDao repartidorDao;
	@Autowired
	private IZonaDao zonaDao;



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

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*").allowedOrigins("*");
			}
		};
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Cliente cliente = new Cliente();
		cliente.setCi("123456");
		cliente.setNombres("Flavio");
		cliente.setApellidos("Arteaga");
		cliente.setTelefono("74441781");
		cliente.setNit("111AAA");
		cliente.setLatitud(12.031313);
		cliente.setLongitud(-12.031313);
		clienteDao.save(cliente);


		Producto producto = new Producto();
		producto.setCodigo("A1234");
		producto.setNombre("Botellones de Agua");
		producto.setStock(200);
		producto.setPrecio_venta(20);
		producto.setEstado(1);
		productoDao.save(producto);

		Repartidor repartidor = new Repartidor();
		repartidor.setCi("2121");
		repartidor.setNombres("Daniel");
		repartidor.setApellidos("Fuentes");
		repartidor.setTurnoHorario("Diurno");
		repartidor.setTelefono("78784542");

		repartidorDao.save(repartidor);

		Zona zona = new Zona();
		zona.setNombre("Av Guapilo");
		zona.setEstado(1);

		zonaDao.save(zona);





	}



}
