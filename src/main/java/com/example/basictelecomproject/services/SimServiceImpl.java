package com.example.basictelecomproject.services;

import com.example.basictelecomproject.domain.Sim;
import com.example.basictelecomproject.repository.SimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("SimService")
public class SimServiceImpl implements SimService {

    @Autowired
    SimRepository simRepository;

    @Override
    public Sim getSimById(Long simId) {
        return simRepository.findById(simId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Sim> getAll() {
        return simRepository.findAll();
    }

    @Override
    public List<Sim> getAllocatedSims() {
        return simRepository.findAllocatedSims();
    }

    @Override
    public void addSim(Sim sim) {
        simRepository.save(sim);
    }
}
