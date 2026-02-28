package com.group.bank.service;

import javax.persistence.*;
import java.util.List;

import com.group.bank.entity.*;

public class BankService {

    private EntityManager em;

    public BankService(EntityManager em) {
        this.em = em;
    }

    // 1. Register Customer
    public void registerCustomer(String name, String email, String phone) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Customer customer = new Customer(name, email, phone);
            em.persist(customer);
            tx.commit();
            System.out.println("Customer Registered!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    // 2. Open Account
    public void openAccount(Long customerId, String accountType, double initialBalance) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);
            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }

            Account account = new Account(accountType, initialBalance, customer);
            em.persist(account);

            tx.commit();
            System.out.println("Account Opened!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    // 3. Deposit
    public void deposit(Long accountId, double amount) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Account account = em.find(Account.class, accountId);
            account.setBalance(account.getBalance() + amount);

            Transaction t = new Transaction("Deposit", amount, account);
            em.persist(t);

            tx.commit();
            System.out.println("Deposit Successful!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    // 4. Withdraw
    public void withdraw(Long accountId, double amount) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Account account = em.find(Account.class, accountId);

            if (account.getBalance() < amount) {
                System.out.println("Insufficient Balance!");
                return;
            }

            account.setBalance(account.getBalance() - amount);

            Transaction t = new Transaction("Withdraw", amount, account);
            em.persist(t);

            tx.commit();
            System.out.println("Withdrawal Successful!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    // 5. View Account Statement
    public void viewStatement(Long accountId) {
        TypedQuery<Transaction> query =
                em.createQuery("SELECT t FROM Transaction t WHERE t.account.id = :id", Transaction.class);
        query.setParameter("id", accountId);

        List<Transaction> transactions = query.getResultList();

        for (Transaction t : transactions) {
            System.out.println("Transaction: " + t);
        }
    }

    // 6. View Accounts by Customer
    public void viewAccounts(Long customerId) {
        TypedQuery<Account> query =
                em.createQuery("SELECT a FROM Account a WHERE a.customer.id = :id", Account.class);
        query.setParameter("id", customerId);

        List<Account> accounts = query.getResultList();

        for (Account a : accounts) {
            System.out.println("Account ID: " + a.getId()
                    + " | Balance: " + a.getBalance());
        }
    }
}