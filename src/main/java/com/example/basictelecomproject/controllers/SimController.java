package com.example.basictelecomproject.controllers;

import com.example.basictelecomproject.domain.Sim;
import com.example.basictelecomproject.services.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SimController {

    @Autowired
    SimService simService;

    @RequestMapping(value = "/sim", method = RequestMethod.GET)
    public String showCusomer(Model model) {
        model.addAttribute("sim", new Sim() );
        return "sim";
    }

    @RequestMapping(value = "/sim", method = RequestMethod.POST)
    public String addCusomer(Model model, @ModelAttribute("sim") @Valid Sim sim,
                             Errors errors) {
        simService.addSim(sim);
        return "sim";
    }
}
