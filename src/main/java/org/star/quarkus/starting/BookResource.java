package org.star.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;
    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Getting all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int count() {
        logger.info("Counting books");
        return bookRepository.getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") int id) {
        logger.info("Getting book with id " + id);
        return bookRepository.getBook(id).orElseThrow(() -> new IllegalArgumentException("Book with id " + id + " not found"));
    }
}
