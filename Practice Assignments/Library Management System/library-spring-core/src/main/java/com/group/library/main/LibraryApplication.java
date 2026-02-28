package com.group.library.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.group.library.config.AppConfig;
import com.group.library.service.*;

import java.util.Scanner;

public class LibraryApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BookService bookService = context.getBean(BookService.class);
        MemberService memberService = context.getBean(MemberService.class);
        LibraryService libraryService = context.getBean(LibraryService.class);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== LIBRARY MENU ===");
            System.out.println("1. Register Member");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    memberService.registerMember(name, email);
                    break;

                case 2:
                    System.out.print("Title: ");
                    String title = sc.next();
                    System.out.print("Author: ");
                    String author = sc.next();
                    bookService.addBook(title, author);
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    Long mid = sc.nextLong();
                    System.out.print("Book ID: ");
                    Long bid = sc.nextLong();
                    libraryService.issueBook(mid, bid);
                    break;

                case 4:
                    System.out.print("Member ID: ");
                    Long mid2 = sc.nextLong();
                    System.out.print("Book ID: ");
                    Long bid2 = sc.nextLong();
                    libraryService.returnBook(mid2, bid2);
                    break;

                case 5:
                    bookService.getAvailableBooks()
                            .forEach(b ->
                                    System.out.println(b.getId() + " - " + b.getTitle()));
                    break;

                case 6:
                    context.close();
                    System.exit(0);
            }
        }
    }
}