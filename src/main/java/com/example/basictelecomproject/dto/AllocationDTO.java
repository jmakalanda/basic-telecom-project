package com.example.basictelecomproject.dto;

public class AllocationDTO {
    private Long customerId;
    private Long simId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSimId() {
        return simId;
    }

    public void setSimId(Long simId) {
        this.simId = simId;
    }
}
