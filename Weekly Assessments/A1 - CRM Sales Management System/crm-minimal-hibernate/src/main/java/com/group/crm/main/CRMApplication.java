package com.group.crm.main;

import javax.persistence.*;
import java.util.*;

import com.group.crm.service.*;

public class CRMApplication {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("crmPU");

        EntityManager em = emf.createEntityManager();

        CustomerService customerService = new CustomerService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== CRM MENU =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Product");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Phone: ");
                    String phone = sc.next();

                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Product Name: ");
                    String pname = sc.next();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    productService.addProduct(pname, price);
                    break;

                case 3:
                    System.out.print("Customer ID: ");
                    Long cid = sc.nextLong();

                    System.out.print("Enter Product IDs (comma separated): ");
                    sc.nextLine();
                    String input = sc.nextLine();

                    String[] ids = input.split(",");
                    List<Long> productIds = new ArrayList<>();

                    for (String id : ids) {
                        productIds.add(Long.parseLong(id.trim()));
                    }

                    orderService.placeOrder(cid, productIds);
                    break;

                case 4:
                    orderService.viewAllOrders();
                    break;

                case 5:
                    em.close();
                    emf.close();
                    System.exit(0);
            }
        }
    }
}