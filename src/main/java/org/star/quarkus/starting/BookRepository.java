package org.star.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "The Fellowship of the Ring", "J.R.R. Tolkien", 1954, "Fantasy"),
                new Book(2, "The Two Towers", "J.R.R. Tolkien", 1954, "Fantasy"),
                new Book(3, "The Return of the King", "J.R.R. Tolkien", 1955, "Fantasy"),
                new Book(4, "The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy")
        );
    }


    public Optional<Book> getBook(@PathParam("id") int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
