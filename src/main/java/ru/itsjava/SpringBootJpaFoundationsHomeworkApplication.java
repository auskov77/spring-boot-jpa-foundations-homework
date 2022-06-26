package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.services.CustomerService;
import ru.itsjava.services.PetService;

@SpringBootApplication
public class SpringBootJpaFoundationsHomeworkApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class, args);
		CustomerService customerService = context.getBean(CustomerService.class);
		customerService.printAllCustomers();

		PetService petService = context.getBean(PetService.class);
		petService.changePet("yard", "domestic");
		petService.printPet("domestic");
	}

}
