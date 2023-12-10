package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Book;
import mk.finki.ukim.wp.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BookStoreRepository {

    public List<BookStore> findAll() {
        return DataHolder.bookStores;
    }

    public BookStore findById(Long id) {
//        List<BookStore> bss = DataHolder.bookStores;
//        DataHolder.abookStores.forEach(x -> {
//            System.out.println(x.getId());
//            System.out.println(x.getId().equals(id));
//            System.out.println(id);
//        });
        return DataHolder.bookStores.stream().filter(bookStore -> Objects.equals(bookStore.getId(), id)).findFirst().orElse(null);
    }
}
