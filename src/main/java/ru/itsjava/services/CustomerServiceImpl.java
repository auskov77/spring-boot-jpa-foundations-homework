package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Customer;
import ru.itsjava.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    @Override
    public void printAllCustomers() {
        System.out.println("Наши владельцы: ");
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers.toString());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id);
    }

    @Transactional
    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
