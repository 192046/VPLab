package mk.finki.ukim.wp.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookStore {
    private Long id;
    private String name;
    private String city;
    private String address;
    private List<Book> books;

    public BookStore(String name, String city, String address) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.city = city;
        this.address = address;
        this.books = new ArrayList<>();
    }
}
