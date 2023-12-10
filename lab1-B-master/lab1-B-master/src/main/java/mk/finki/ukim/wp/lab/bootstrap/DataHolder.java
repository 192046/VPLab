package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import jdk.jfr.Category;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors = null;
    public static List<Book> books = null;
    public static List<BookStore> bookStores = null;

    @PostConstruct
    public void init() {
        authors = new ArrayList<>();
        authors.add(new Author(1L, "John", "Doe", "John Doe is a talented writer with a passion for storytelling."));
        authors.add(new Author(2L, "Jane", "Smith", "Jane Smith is an accomplished author known for her best-selling novels."));
        authors.add(new Author(3L, "Robert", "Johnson", "Robert Johnson's writing style captivates readers with its unique blend of humor and drama."));
        authors.add(new Author(4L, "Maria", "Garcia", "Maria Garcia is a renowned author whose novels have been translated into multiple languages."));
        authors.add(new Author(5L, "Michael", "Brown", "Michael Brown is an emerging writer with a fresh perspective on contemporary issues."));
        bookStores = new ArrayList<>();
        BookStore bookStore1 = new BookStore("Book Haven", "New York", "123 Main St");
        BookStore bookStore2 = new BookStore("City Books", "Los Angeles", "456 Oak Ave");
        BookStore bookStore3 = new BookStore("Readers' Paradise", "Chicago", "789 Elm Blvd");
        BookStore bookStore4 = new BookStore("Novel Nook", "San Francisco", "101 Pine Lane");
        BookStore bookStore5 = new BookStore("Literary Lounge", "Seattle", "202 Maple Dr");
        bookStores.add(bookStore1);
        bookStores.add(bookStore2);
        bookStores.add(bookStore3);
        bookStores.add(bookStore4);
        bookStores.add(bookStore5);
        books = new ArrayList<>();
        books.add(new Book("978-0142437344", "The Great Gatsby", "Fiction", 1925, new ArrayList<>(), bookStore1));
        books.add(new Book("978-0061120084", "To Kill a Mockingbird", "Fiction", 1960, new ArrayList<>(), bookStore2));
        books.add(new Book("978-0451524935", "1984", "Science Fiction", 1949, new ArrayList<>(), bookStore3));
        books.add(new Book("978-0316769488", "The Catcher in the Rye", "Fiction", 1951, new ArrayList<>(), bookStore4));
        books.add(new Book("978-1980497193", "Pride and Prejudice", "Romance", 1813, new ArrayList<>(), bookStore5));
    }
}
