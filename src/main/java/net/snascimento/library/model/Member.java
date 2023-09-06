package net.snascimento.library.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "library_member")
public class Member {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private MemberStatus status;
}
