package com.example.basictelecomproject.dto;

public class AllocatedSimDTO {
    Long customerId;
    String customerName;
    Long simIid;
    String phoneNumber;


    public AllocatedSimDTO(Long customerId, String customerName, Long simIid, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.simIid = simIid;
        this.phoneNumber = phoneNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getSimIid() {
        return simIid;
    }

    public void setSimIid(Long simIid) {
        this.simIid = simIid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
