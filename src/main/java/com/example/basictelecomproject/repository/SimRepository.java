package com.example.basictelecomproject.repository;

import com.example.basictelecomproject.domain.Sim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimRepository extends JpaRepository<Sim, Long> {
    @Query("SELECT S FROM Sim S WHERE S.customer.id IS NOT NULL")
    List<Sim> findAllocatedSims();
}
