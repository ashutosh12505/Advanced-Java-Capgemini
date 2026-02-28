package com.group.crm.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import com.group.crm.entity.Customer;
import com.group.crm.entity.Product;
import com.group.crm.entity.CustomerOrder;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Long customerId, List<Long> productIds) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            List<Product> products = new ArrayList<>();
            double total = 0;

            for (Long id : productIds) {
                Product product = em.find(Product.class, id);
                if (product != null) {
                    products.add(product);
                    total += product.getPrice();
                }
            }

            CustomerOrder order = new CustomerOrder(customer, products, total);
            em.persist(order);

            tx.commit();
            System.out.println("Order Placed Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public void viewAllOrders() {
        TypedQuery<CustomerOrder> query =
                em.createQuery("SELECT o FROM CustomerOrder o", CustomerOrder.class);

        List<CustomerOrder> orders = query.getResultList();

        for (CustomerOrder o : orders) {
            System.out.println("Order ID: " + o.getId()
                    + " | Total: " + o.getTotalAmount());
        }
    }
}