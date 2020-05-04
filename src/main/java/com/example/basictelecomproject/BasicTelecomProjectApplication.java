package com.example.basictelecomproject;

import com.example.basictelecomproject.domain.Customer;
import com.example.basictelecomproject.domain.Sim;
import com.example.basictelecomproject.repository.CustomerRepository;
import com.example.basictelecomproject.repository.SimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class BasicTelecomProjectApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SimRepository simRepository;

    public static void main(String[] args) {
        SpringApplication.run(BasicTelecomProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepository.save(new Customer("Jack", "Italy",new SimpleDateFormat("yyyy-MM-dd").parse("2000-05-04")));
        customerRepository.save(new Customer("Adam", "US", new SimpleDateFormat("yyyy-MM-dd").parse("1970-05-05")));
        customerRepository.save(new Customer("Harry", "Italy",new SimpleDateFormat("yyyy-MM-dd").parse("1990-05-11")));
        customerRepository.save(new Customer("David", "Japan", new SimpleDateFormat("yyyy-MM-dd").parse("1970-05-12")));
        customerRepository.save(new Customer("Peter", "Canada",new SimpleDateFormat("yyyy-MM-dd").parse("1980-05-11")));

        simRepository.save(new Sim("1111111111"));
        simRepository.save(new Sim("2222222222"));
        simRepository.save(new Sim("3333333333"));
        simRepository.save(new Sim("4444444444"));
        simRepository.save(new Sim("5555555555"));

    }
}
