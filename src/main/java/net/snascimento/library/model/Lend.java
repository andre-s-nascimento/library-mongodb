package net.snascimento.library.model;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Lend {

    @Id
    private String id;
    private LendStatus status;
    private Instant startOn;
    private Instant dueOn;
    @DBRef
    private Book book;
    @DBRef
    private Member member;
}
