package org.acme.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.Book;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio Goncalves" , 2020, "IT"),
                new Book(2, "Praticising Quarkus", "Antonio Goncalves" , 2020, "IT"),
                new Book(3, "Effective Java", "Josh Bloch" , 2001, "IT"),
                new Book(4, "Thinking in Java", "Bruce Eckel" , 1998, "IT"));
    }

    public Optional<Book> getBookById(int id) {
        return getAllBooks().stream().filter(book -> book.getId() == id).findFirst();
    }
}
