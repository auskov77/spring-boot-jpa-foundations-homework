package ru.itsjava.services;

import ru.itsjava.domain.Customer;
import ru.itsjava.domain.Pet;

import java.util.List;

public interface CustomerService {
    void printAllCustomers();

    List<Customer> getAllCustomers();

    Customer getCustomerById(long id);

    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
