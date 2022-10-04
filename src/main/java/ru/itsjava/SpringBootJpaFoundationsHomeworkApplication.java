package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJpaFoundationsHomeworkApplication {

	public static void main(String[] args) throws SQLException {
//		SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class, args);
		PetRepository petRepository = context.getBean(PetRepository.class);

		System.out.println("petRepository.findById(1L) = " + petRepository.findById(1L));

		Pet newPet = new Pet(0L, "domestic");
		petRepository.insert(newPet);

		System.out.println("petRepository.findById(5L) = " + petRepository.findById(5L));

		Pet updatePet = petRepository.findById(5L);
		updatePet.setBreed("DOMESTIC");
		petRepository.update(updatePet);
		System.out.println("petRepository.findById(5L) = " + petRepository.findById(5L));

		petRepository.deleteById(5L);
		System.out.println("petRepository.findById(5L) = " + petRepository.findById(5L));


//		Console.main(args);
	}

}