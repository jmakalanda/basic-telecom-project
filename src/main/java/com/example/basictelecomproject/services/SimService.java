package com.example.basictelecomproject.services;

import com.example.basictelecomproject.domain.Sim;

import java.util.List;
import java.util.Set;

public interface SimService {
    void addSim(Sim sim);

    List<Sim> getAll();

    Sim getSimById(Long simId);

    List<Sim> getAllocatedSims();
}
