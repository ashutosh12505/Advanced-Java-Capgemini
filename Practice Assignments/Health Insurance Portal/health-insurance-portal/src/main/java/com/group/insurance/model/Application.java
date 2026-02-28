package com.group.insurance.model;

public class Application {

    private Long id;
    private Long customerId;
    private Long planId;
    private String status;

    public Application(Long id, Long customerId, Long planId, String status) {
        this.id = id;
        this.customerId = customerId;
        this.planId = planId;
        this.status = status;
    }

    public Long getCustomerId() { return customerId; }
    public String getStatus() { return status; }
}