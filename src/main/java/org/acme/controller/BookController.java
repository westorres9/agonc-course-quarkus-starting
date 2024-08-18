package org.acme.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.entities.Book;
import org.acme.services.BookService;
import org.jboss.logging.Logger;

import java.util.List;


@ApplicationScoped
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    BookService bookService;
    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Returns all the books");
        return bookService.getAllBooks();
    }

    @GET
    @Path("{id}")
    public Book getBookById(@PathParam("id") int id) {
        logger.info("Returns the book with id " + id);
        return bookService.getBookById(id);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Returns the number of books");
        return bookService.getAllBooks().size();
    }
}
