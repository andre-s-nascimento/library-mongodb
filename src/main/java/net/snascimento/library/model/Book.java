package net.snascimento.library.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "library_book")
public class Book {
    @Id
    private String id;
    private String name;
    private String isbn;
    @DBRef
    private Author author;

}
