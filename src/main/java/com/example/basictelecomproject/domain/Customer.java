package com.example.basictelecomproject.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Sim> sims;

    public Customer(String name, String address, Date dob) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.sims = new HashSet<>();
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set<Sim> getSims() {
        return sims;
    }

    public void setSims(Set<Sim> sims) {
        this.sims = sims;
    }

    public void setSim(Sim simById) {
        this.sims.add(simById);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                '}';
    }
}
