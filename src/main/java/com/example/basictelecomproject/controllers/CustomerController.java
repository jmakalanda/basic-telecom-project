package com.example.basictelecomproject.controllers;

import com.example.basictelecomproject.domain.Customer;
import com.example.basictelecomproject.services.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping(value = "/getcustomer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCusomer(@PathVariable("id") Long id) {
        logger.info("Customer with the id " + id + " returned");
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String showCusomer(Model model) {
        model.addAttribute("customer", new Customer() );
        customerService.getCustomersHasDOBin7Days();
        return "customer";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String addCusomer(Model model, @ModelAttribute("customer") @Valid Customer customer) {
        customerService.addCustomer(customer);
        return "customer";
    }

    @RequestMapping(value = "/dobreport", method = RequestMethod.GET)
    public String showCusomerDOBReport(Model model) {
        model.addAttribute("customers", customerService.getCustomersHasDOToday());
        logger.info("DOB report produced");
        return "dobreport";
    }
}
