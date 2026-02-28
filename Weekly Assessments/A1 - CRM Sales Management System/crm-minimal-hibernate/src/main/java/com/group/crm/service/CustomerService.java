package com.group.crm.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.group.crm.entity.Customer;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public void registerCustomer(String name, String email, String phone) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Customer customer = new Customer(name, email, phone);
            em.persist(customer);
            tx.commit();
            System.out.println("Customer Registered Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public Customer findCustomer(Long id) {
        return em.find(Customer.class, id);
    }
}