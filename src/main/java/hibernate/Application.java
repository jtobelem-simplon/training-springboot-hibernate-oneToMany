package hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hibernate.service.MainService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	MainService mainService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		mainService.delete();
		mainService.create();
		
		mainService.specificQueries();
		mainService.hqlQuery();
		
		mainService.update();
		mainService.read();
	}

}
