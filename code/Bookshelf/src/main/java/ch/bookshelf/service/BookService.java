package ch.bookshelf.service;

import ch.bookshelf.data.DataHandler;
import ch.bookshelf.model.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Path("book")
public class BookService {
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBooks() {
        List<Book> bookList = DataHandler.getInstance().readAllBooks();
        Response response = Response
                .status(200)
                .entity(bookList)
                .build();
        return response;
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readBook(
            @QueryParam("uuid") String bookUUID
    ) {
        int httpStatus = 200;
        Book book = DataHandler.getInstance().readBookByUUID(bookUUID);
        if (book == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(book)
                .build();
    }

    @Path("create")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertBook(
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("publisherUUID") String publisherUUID,
            @FormParam("price") BigDecimal price,
            @FormParam("isbn") String isbn
    ) {
        Book book = new Book();
        book.setBookUUID(UUID.randomUUID().toString());
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisherUUID(publisherUUID);
        book.setPrice(price);
        book.setIsbn(isbn);

        DataHandler.getInstance().insertBook(book);

        int httpStatus = 200;
        return Response
                .status(httpStatus)
                .entity("Book erfolgreich angelegt")
                .build();
    }

    @Path("delete")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertBook(
            @QueryParam("uuid") String bookUUID
    ) {
        DataHandler.getInstance().deleteBook(bookUUID);

        int httpStatus = 200;
        return Response
                .status(httpStatus)
                .entity("Book erfolgreich gelöscht")
                .build();
    }

    @Path("update")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateBook(
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("publisherUUID") String publisherUUID,
            @FormParam("price") BigDecimal price,
            @FormParam("isbn") String isbn,
            @FormParam("bookUUID") String bookUUID
    ) {
        Book book = DataHandler.getInstance().readBookByUUID(bookUUID);
        book.setBookUUID(UUID.randomUUID().toString());
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisherUUID(publisherUUID);
        book.setPrice(price);
        book.setIsbn(isbn);
        book.setBookUUID(bookUUID);

        DataHandler.getInstance().updateBook(book);

        int httpStatus = 200;
        return Response
                .status(httpStatus)
                .entity("Book erfolgreich angelegt")
                .build();
    }
}
