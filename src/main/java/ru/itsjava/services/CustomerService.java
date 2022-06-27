package ru.itsjava.services;

import ru.itsjava.domain.Customer;

import java.util.List;

public interface CustomerService {
    void printAllCustomers();
    List<Customer> getAllCustomers();
}
