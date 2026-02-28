package com.group.library.service;

import org.springframework.stereotype.Service;
import com.group.library.repository.BookRepository;
import com.group.library.model.Book;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author) {
        bookRepository.save(title, author);
        System.out.println("Book Added!");
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findAll()
                .stream()
                .filter(Book::isAvailable)
                .toList();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }
}