package com.example.basictelecomproject.services;

import com.example.basictelecomproject.domain.Customer;
import com.example.basictelecomproject.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

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
            logger.debug("Month and Day of the DOB is: "  + calDOB.get(Calendar.MONTH)  + " and  "+ calDOB.get(calDOB.DAY_OF_MONTH));

            calDOB.add(Calendar.DAY_OF_MONTH,-7);
            logger.debug("Month and Day of today is: " + calToday.get(Calendar.MONTH) + " and " + calToday.get(calToday.DAY_OF_MONTH ));

            if ((calToday.get(Calendar.DAY_OF_MONTH ) == calDOB.get(calDOB.DAY_OF_MONTH)) && (calToday.get(Calendar.MONTH ) == calDOB.get(calDOB.MONTH))){
                dobCustomers.add(c);
                logger.debug("The Customer "+ c.getName() + " has his birthday in 7 days time on " + c.getDob());
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
