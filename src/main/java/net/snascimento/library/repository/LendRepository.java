package net.snascimento.library.repository;

import java.util.Optional;
import net.snascimento.library.model.Book;
import net.snascimento.library.model.Lend;
import net.snascimento.library.model.LendStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LendRepository extends MongoRepository<Lend,String> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}
