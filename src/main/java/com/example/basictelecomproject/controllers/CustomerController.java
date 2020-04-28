package com.example.basictelecomproject.controllers;

import com.example.basictelecomproject.domain.Customer;
import com.example.basictelecomproject.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping(value = "/getcustomer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCusomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String showCusomer(Model model) {
        model.addAttribute("customer", new Customer() );
        customerService.getCustomersHasDOBin7Days();
        return "customer";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String addCusomer(Model model, @ModelAttribute("customer") @Valid Customer customer,
                             Errors errors) {
        //acctual logic happen here
        customerService.addCustomer(customer);
        return "customer";
    }

    @RequestMapping(value = "/dobreport", method = RequestMethod.GET)
    public String showCusomerDOBReport(Model model) {
        model.addAttribute("customers", customerService.getCustomersHasDOToday());
        return "dobreport";
    }
}
