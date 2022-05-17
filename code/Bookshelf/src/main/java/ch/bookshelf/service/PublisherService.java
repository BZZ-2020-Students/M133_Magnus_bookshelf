package ch.bookshelf.service;

import ch.bookshelf.data.DataHandler;
import ch.bookshelf.model.Publisher;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("publisher")
public class PublisherService {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPublishers() {
        List<Publisher> publisherList = DataHandler.getInstance().readAllPublishers();
        return Response
                .status(200)
                .entity(publisherList)
                .build();
    }

    /**
     * reads a publisher identified by the uuid
     * @param publisherUUID
     * @return publisher
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPublisher(
            @QueryParam("uuid") String publisherUUID
    ) {
        int httpStatus = 200;
        Publisher publisher = DataHandler.getInstance().readPublisherByUUID(publisherUUID);
        if (publisher == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(publisher)
                .build();
    }
}
