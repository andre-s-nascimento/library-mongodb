package net.snascimento.library.repository;

import net.snascimento.library.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {}
