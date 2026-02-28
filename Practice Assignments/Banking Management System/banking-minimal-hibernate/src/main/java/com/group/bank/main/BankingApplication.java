package com.group.bank.main;

import javax.persistence.*;
import java.util.Scanner;

import com.group.bank.service.BankService;

public class BankingApplication {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("bankPU");

        EntityManager em = emf.createEntityManager();

        BankService service = new BankService(em);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Register Customer");
            System.out.println("2. Open Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Account Statement");
            System.out.println("6. View Customer Accounts");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Phone: ");
                    String phone = sc.next();
                    service.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Customer ID: ");
                    Long cid = sc.nextLong();
                    System.out.print("Account Type: ");
                    String type = sc.next();
                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();
                    service.openAccount(cid, type, bal);
                    break;

                case 3:
                    System.out.print("Account ID: ");
                    Long accId = sc.nextLong();
                    System.out.print("Amount: ");
                    double dep = sc.nextDouble();
                    service.deposit(accId, dep);
                    break;

                case 4:
                    System.out.print("Account ID: ");
                    Long accId2 = sc.nextLong();
                    System.out.print("Amount: ");
                    double wd = sc.nextDouble();
                    service.withdraw(accId2, wd);
                    break;

                case 5:
                    System.out.print("Account ID: ");
                    Long stId = sc.nextLong();
                    service.viewStatement(stId);
                    break;

                case 6:
                    System.out.print("Customer ID: ");
                    Long custId = sc.nextLong();
                    service.viewAccounts(custId);
                    break;

                case 7:
                    em.close();
                    emf.close();
                    System.exit(0);
            }
        }
    }
}