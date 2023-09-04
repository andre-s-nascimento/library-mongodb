package net.snascimento.library.model.request;

import lombok.Data;

import java.util.List;

@Data
public class BookLendRequest {
    private List<String> bookIds;
    private String memberId;
}
