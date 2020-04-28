package com.example.basictelecomproject.controllers;

import com.example.basictelecomproject.domain.Sim;
import com.example.basictelecomproject.dto.AllocatedSimDTO;
import com.example.basictelecomproject.dto.AllocationDTO;
import com.example.basictelecomproject.services.CustomerServiceImpl;
import com.example.basictelecomproject.services.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AllocationController {

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    SimService simService;


    @RequestMapping(value = "/allocate", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("sims", simService.getAll());
        model.addAttribute("allocation", new AllocationDTO());
        model.addAttribute("allocatedsims", getAllocatedSims());
        return "allocate";
    }

    @RequestMapping(value = "/allocate", method = RequestMethod.POST)
    public String allocate(Model model, AllocationDTO allocation) {
        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("sims", simService.getAll());
        model.addAttribute("allocation", new AllocationDTO());


        System.out.println("The mapping is : " + allocation.getCustomerId() + "" + allocation.getSimId());
        Sim sim= simService.getSimById(allocation.getSimId());
        sim.setCustomer(customerService.getCustomer(allocation.getCustomerId()));
        simService.addSim(sim);

        model.addAttribute("allocatedsims", getAllocatedSims());
        model.addAttribute("sims", simService.getAll());

        return "allocate";
    }

    private List<AllocatedSimDTO> getAllocatedSims() {
        List<Sim> sims = simService.getAllocatedSims();
        List<AllocatedSimDTO> allocatedSims = new ArrayList<>();
        for (Sim sim : sims) {
            allocatedSims.add(new AllocatedSimDTO(sim.getCustomer().getId(), sim.getCustomer().getName(), sim.getId(), sim.getPhoneNumber()));
        }
        return allocatedSims;
    }
}