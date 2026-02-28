package com.group.insurance.service;

import org.springframework.stereotype.Service;
import com.group.insurance.model.*;

import java.util.*;

@Service
public class InsuranceService {

    private List<Customer> customers = new ArrayList<>();
    private List<Plan> plans = new ArrayList<>();
    private List<Application> applications = new ArrayList<>();

    private Long customerId = 1L;
    private Long applicationId = 1L;

    public InsuranceService() {
        plans.add(new Plan(1L, "Basic Health Plan", "Basic coverage"));
        plans.add(new Plan(2L, "Premium Health Plan", "Extended coverage"));
        plans.add(new Plan(3L, "Family Coverage Plan", "Family protection"));
    }

    public void registerCustomer(String name, int age, String email, String city) {
        customers.add(new Customer(customerId++, name, age, email, city));
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void applyPlan(Long customerId, Long planId) {
        applications.add(new Application(applicationId++, customerId, planId, "Pending"));
    }

    public String checkStatus(Long customerId) {
        return applications.stream()
                .filter(a -> a.getCustomerId().equals(customerId))
                .map(Application::getStatus)
                .findFirst()
                .orElse("No Application Found");
    }
}