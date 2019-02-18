package hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hibernate.service.OneToManyService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	OneToManyService crudService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		crudService.delete();
		crudService.create();
		crudService.hqlQuery("");
//		crudService.update();
//		crudService.read();
	}

}
