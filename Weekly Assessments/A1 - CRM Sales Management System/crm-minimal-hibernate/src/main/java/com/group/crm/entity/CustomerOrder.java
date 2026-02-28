package com.group.crm.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;
    private double totalAmount;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;

    public CustomerOrder() {}

    public CustomerOrder(Customer customer, List<Product> products, double totalAmount) {
        this.customer = customer;
        this.products = products;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public double getTotalAmount() { return totalAmount; }
}