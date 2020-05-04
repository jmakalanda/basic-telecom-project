package com.example.basictelecomproject.services;

import com.example.basictelecomproject.domain.Customer;
import com.example.basictelecomproject.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    CustomerRepository customerRepository;
    //List<Customer> allCustomers = null;

    @BeforeEach
    protected void setUp() throws ParseException{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    protected void getCustomersHasDOBin7DaysTest() throws ParseException{
        List<Customer> allCustomers = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 7);
        allCustomers.add(new Customer("Jack", "Italy", c.getTime()));
        allCustomers.add(new Customer("Adam", "US", c.getTime()));

        when(customerRepository.findAll()).thenReturn(allCustomers);
        List<Customer> customers = customerService.getCustomersHasDOBin7Days();

        assertNotNull(customers);
        assertEquals("Jack",customers.get(0).getName());
    }
    @Test
    public void getCustomersHasDOTodayTest(){
        List<Customer> allCustomers = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        allCustomers.add(new Customer("Adam", "US", c.getTime()));

        when(customerRepository.findAll()).thenReturn(allCustomers);
        List<Customer> customers = customerService.getCustomersHasDOToday();

        assertNotNull(customers);
        assertEquals("Adam",customers.get(0).getName());
    }


}
