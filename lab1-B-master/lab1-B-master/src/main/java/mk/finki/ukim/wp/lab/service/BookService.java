package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Author;
import mk.finki.ukim.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService{
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
    void deleteAuthorsForBook(Book book);
    Optional<Book> save(String title, String isbn, String genre, int year, Long bookStoreId);
    Book findById(Long id);
    void deleteById(Long id);
}
