package com.example.basictelecomproject.repository;

import com.example.basictelecomproject.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
/*  //native query doesn't work - looks like a limitation in Hibernate
    @Query("SELECT * FROM CUSTOMER WHERE MONTH(DATEADD('DAY',+7, DOB)) = MONTH(CURRENT_DATE) AND DAY(DATEADD('DAY',+7, DOB)) = DAY(CURRENT_DATE)")
    List<Customer> getCustomersHasDOBin7Days();
*/
}
