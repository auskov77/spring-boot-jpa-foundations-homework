package ru.itsjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsjava.domain.Customer;
import ru.itsjava.domain.Pet;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    void deleteAllByPet(Pet pet);
    Optional<Customer> findCustomerByNameAndPet(String name, Pet pet);
}
