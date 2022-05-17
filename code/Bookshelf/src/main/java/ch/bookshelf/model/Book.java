package ch.bookshelf.model;

import ch.bookshelf.data.DataHandler;

import java.math.BigDecimal;

public class Book {
    private String bookUUID;
    private String title;
    private String author;
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
        getPublisher().setPublisher(publisher.getPublisher());

    }

    public String getBookUUID() {
        return bookUUID;
    }

    public void setBookUUID(String bookUUID) {
        this.bookUUID = bookUUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
