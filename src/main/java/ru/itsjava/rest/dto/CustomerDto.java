package ru.itsjava.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Customer;
import ru.itsjava.domain.Pet;

@AllArgsConstructor
@Data
public class CustomerDto {
    private String id;
    private String name;
    private String email;
    private String animal;

    public static Customer fromDto(CustomerDto customerDto) {
        long id = Long.parseLong(customerDto.id);
        Pet pet = new Pet(0L, customerDto.animal);

        return new Customer(id, customerDto.name, customerDto.email, customerDto.animal, pet);
    }

    public static CustomerDto toDto(Customer customer) {
        String id = String.valueOf(customer.getId());
        String name = customer.getName();
        String email = customer.getEmail();
        String animal = customer.getAnimal();

        return new CustomerDto(id, name, email, animal);
    }
}
