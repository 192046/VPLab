package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    public List<Book> findAll() {
        return DataHolder.books;
    }

    public Book findByIsbn(String isbn) {
        return DataHolder.books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    public Author addAuthorToBook(Author author, Book book) {
        book.getAuthors().add(author);
        return author;
    }

    public void deleteAllAuthors(Book book) {
        findByIsbn(book.getIsbn()).setAuthors(new ArrayList<>());
    }

    public Optional<Book> save(String title, String isbn, String genre, int year, BookStore bookStore) {
        DataHolder.books.removeIf(book -> book.getIsbn().equals(isbn));
        Book book = new Book(isbn, title, genre, year, new ArrayList<>(), bookStore);
        DataHolder.books.add(book);

        return Optional.of(book);
    }

    public Book findById(Long id) {
        return DataHolder.books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Long id) {
        DataHolder.books.removeIf(book -> book.getId().equals(id));
    }
}
