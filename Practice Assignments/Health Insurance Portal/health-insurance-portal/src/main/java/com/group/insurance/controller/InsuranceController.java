package com.group.insurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.group.insurance.service.InsuranceService;

@Controller
public class InsuranceController {

    private final InsuranceService service;

    public InsuranceController(InsuranceService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String home() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam int age,
                           @RequestParam String email,
                           @RequestParam String city) {

        service.registerCustomer(name, age, email, city);
        return "success";
    }

    @RequestMapping("/plans")
    public String viewPlans(Model model) {
        model.addAttribute("plans", service.getPlans());
        return "plans";
    }

    @PostMapping("/apply")
    public String apply(@RequestParam Long customerId,
                        @RequestParam Long planId) {

        service.applyPlan(customerId, planId);
        return "applied";
    }

    @RequestMapping("/status")
    public String status(@RequestParam Long customerId, Model model) {
        model.addAttribute("status", service.checkStatus(customerId));
        return "status";
    }
    
    @RequestMapping("/statusForm")
    public String statusForm() {
        return "statusForm";
    }
}