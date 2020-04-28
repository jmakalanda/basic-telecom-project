package com.example.basictelecomproject.configuration;


import com.example.basictelecomproject.domain.Customer;
import com.example.basictelecomproject.services.CustomerService;
import com.example.basictelecomproject.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {

    @Autowired
    EmailService emailService;
    @Autowired
    CustomerService customerService;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 300000)
    public void scheduleDOBEmailTask() {
        String to = "Jmakalanda@gmail.com";
        String subject= "Customers having birthdays in 7 days";
        String emailBody = "Dear Operator, \n Please find below the list of customers having birthdays in 7 days \n";
        List<Customer> customerList = customerService.getCustomersHasDOBin7Days();
        for( Customer customer: customerList){
            System.out.println(customer.toString());
            emailBody = emailBody + "\n" + customer.toString();
        }

        emailService.sendSimpleMessage(to, subject, emailBody);
        System.out.println("DOB email sent :" + dateTimeFormatter.format(LocalDateTime.now()) );
    }

}