package mk.finki.ukim.wp.lab.model;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private Long id;
    private String isbn;
    private String title;
    private String genre;
    private int year;
    private List<Author> authors;
    private BookStore bookStore;

    public Book(String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) {
        this.id = (long) (Math.random() * 1000);
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
    }
}
