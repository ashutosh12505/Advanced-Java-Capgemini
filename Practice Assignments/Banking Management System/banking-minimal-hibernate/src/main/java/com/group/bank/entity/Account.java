package com.group.bank.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountType;
    private double balance;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public Account() {}

    public Account(String accountType, double balance, Customer customer) {
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public Long getId() { return id; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}