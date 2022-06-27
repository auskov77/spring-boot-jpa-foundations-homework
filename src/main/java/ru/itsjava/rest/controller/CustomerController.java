package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itsjava.domain.Customer;
import ru.itsjava.rest.dto.CustomerDto;
import ru.itsjava.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public String customersPage(Model model) {
        List<Customer> allCustomers = customerService.getAllCustomers();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : allCustomers) {
            customerDtos.add(CustomerDto.toDto(customer));
        }

        model.addAttribute("customers", customerDtos);
        return "customers-page";
    }
}
