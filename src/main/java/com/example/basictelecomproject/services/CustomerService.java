package com.example.basictelecomproject.services;

import com.example.basictelecomproject.domain.Customer;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long id);
    void addCustomer(Customer customer);
    List<Customer> getAll();
    Customer findCustomerById(Long id);
    List<Customer> getCustomersHasDOBin7Days();
}
