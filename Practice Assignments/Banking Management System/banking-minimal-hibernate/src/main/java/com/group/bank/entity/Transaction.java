package com.group.bank.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;
    private double amount;
    private LocalDateTime transactionDate;

    @ManyToOne
    private Account account;

    public Transaction() {}

    public Transaction(String type, double amount, Account account) {
        this.transactionType = type;
        this.amount = amount;
        this.account = account;
        this.transactionDate = LocalDateTime.now();
    }
}