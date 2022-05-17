package ch.bookshelf.service;

import ch.bookshelf.data.DataHandler;
import ch.bookshelf.model.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

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
}
