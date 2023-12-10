package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.BookStore;
import mk.finki.ukim.wp.lab.repository.BookStoreRepository;
import mk.finki.ukim.wp.lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public BookStore findById(Long id) {
        return bookStoreRepository.findById(id);
    }
}
