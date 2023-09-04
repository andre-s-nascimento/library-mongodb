package net.snascimento.library.repository;

import java.util.Optional;
import net.snascimento.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findByIsbn(String isbn);
}
