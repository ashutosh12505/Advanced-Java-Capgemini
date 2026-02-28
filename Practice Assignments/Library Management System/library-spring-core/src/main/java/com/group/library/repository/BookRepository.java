package com.group.library.repository;

import org.springframework.stereotype.Repository;
import com.group.library.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();
    private Long idCounter = 1L;

    public Book save(String title, String author) {
        Book book = new Book(idCounter++, title, author);
        books.add(book);
        return book;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}