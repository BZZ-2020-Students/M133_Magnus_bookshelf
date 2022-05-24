package ch.bookshelf.model;

import ch.bookshelf.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookUUID;
    private String title;
    private String author;
    @JsonIgnore
    private Publisher publisher;
    private BigDecimal price;
    private String isbn;

    public String getPublisherUUID() {
        return getPublisher().getPublisherUUID();
    }

    public void setPublisherUUID(String publisherUUID) {
        setPublisher( new Publisher());
        Publisher publisher = DataHandler.getInstance().readPublisherByUUID(publisherUUID);
        getPublisher().setPublisherUUID(publisherUUID);
        getPublisher().setPublisherUUID(publisher.getPublisherUUID());
        getPublisher().setPublisher(publisher.getPublisher());
    }
}
