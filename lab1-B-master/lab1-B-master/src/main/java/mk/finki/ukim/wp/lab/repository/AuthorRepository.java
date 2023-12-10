package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {
//    private final List<Author> authors;

    public AuthorRepository() {

    }
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    public Optional<Author> findById(Long id)
    {
        return DataHolder.authors.stream().filter(author -> author.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        DataHolder.authors.removeIf(author -> author.getId().equals(id));
    }
}
