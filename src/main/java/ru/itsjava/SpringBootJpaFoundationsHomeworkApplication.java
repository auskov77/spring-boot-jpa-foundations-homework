package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ru.itsjava.domain.Pet;
import ru.itsjava.repository.CustomerRepository;
import ru.itsjava.repository.PetRepository;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJpaFoundationsHomeworkApplication {

    public static void main(String[] args) {
//		SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class, args);
        ApplicationContext context = SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class, args);
        PetRepository petRepository = context.getBean(PetRepository.class);

        System.out.println("petRepository.getById(1L) = " + petRepository.getById(1L));

        Pet newPet = new Pet(0L, "domestic");
        petRepository.save(newPet);

        System.out.println("petRepository.getById(5L) = " + petRepository.getById(5L));

        Pet updatePet = petRepository.getById(5L);
        updatePet.setBreed("DOMESTIC");
        petRepository.save(updatePet);
        System.out.println("petRepository.getById(5L) = " + petRepository.getById(5L));

        petRepository.deleteById(5L);
        System.out.println("petRepository.findById(5L) = " + petRepository.findById(5L).isPresent());

        System.out.println("petRepository.getByBreed(\"working\") = " + petRepository.getByBreed("working"));
//		Console.main(args);

        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

        System.out.println("customerRepository.findCustomerByNameAndPet(\"Ivanov\", petRepository.getById(1L)).isPresent() = " +
                customerRepository.findCustomerByNameAndPet("Ivanov",
                        petRepository.getById(1L)).isPresent());
    }

}