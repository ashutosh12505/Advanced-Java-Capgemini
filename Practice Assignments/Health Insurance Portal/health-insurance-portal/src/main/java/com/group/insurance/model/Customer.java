package com.group.insurance.model;

public class Customer {

    private Long id;
    private String name;
    private int age;
    private String email;
    private String city;

    public Customer(Long id, String name, int age, String email, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}