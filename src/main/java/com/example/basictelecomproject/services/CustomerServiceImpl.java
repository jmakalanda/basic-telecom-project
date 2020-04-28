package com.example.basictelecomproject.services;

import com.example.basictelecomproject.domain.Customer;
import com.example.basictelecomproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Customer> getCustomersHasDOBin7Days(){
        List<Customer> allCustomers = getAll();
        List<Customer> dobCustomers = new ArrayList<>();
        Calendar calDOB = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();

        for(Customer c: allCustomers){
            calDOB.setTime(c.getDob());
            calDOB.add(Calendar.DAY_OF_MONTH,-7);

            System.out.println("calDOB Day " + calDOB.get(calDOB.DAY_OF_MONTH) + " , now day " + calToday.get(Calendar.DAY_OF_MONTH ));
            System.out.println("calDOB Month " + calDOB.get(calDOB.MONTH) + " , now month " + calToday.get(calToday.MONTH ));

            if ((calToday.get(Calendar.DAY_OF_MONTH ) == calDOB.get(calDOB.DAY_OF_MONTH)) && (calToday.get(Calendar.MONTH ) == calDOB.get(calDOB.MONTH))){
                dobCustomers.add(c);
                System.out.println("the customer has a birthdays of 7 days before" + c.getName() + " and DOB of " + c.getDob());
            }
        }
        return dobCustomers;
    }
    public List<Customer> getCustomersHasDOToday(){
        List<Customer> allCustomers = getAll();
        List<Customer> dobCustomers = new ArrayList<>();
        Calendar calDOB = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();

        for(Customer c: allCustomers){
            calDOB.setTime(c.getDob());

            if ((calToday.get(Calendar.DAY_OF_MONTH ) == calDOB.get(calDOB.DAY_OF_MONTH)) && (calToday.get(Calendar.MONTH ) == calDOB.get(calDOB.MONTH))){
                dobCustomers.add(c);
                System.out.println("the customer has a birthdays today " + c.getName() + " and DOB of " + c.getDob());
            }
        }
        return dobCustomers;
    }
}
