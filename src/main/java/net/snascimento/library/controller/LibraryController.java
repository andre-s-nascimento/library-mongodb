package net.snascimento.library.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.snascimento.library.model.Author;
import net.snascimento.library.model.Book;
import net.snascimento.library.model.Member;
import net.snascimento.library.model.request.AuthorCreationRequest;
import net.snascimento.library.model.request.BookCreationRequest;
import net.snascimento.library.model.request.BookLendRequest;
import net.snascimento.library.model.request.MemberCreationRequest;
import net.snascimento.library.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/api/library")
@RequiredArgsConstructor
public class LibraryController {
  private final LibraryService libraryService;

  @GetMapping("/book")
  public ResponseEntity readBooks(@RequestParam(required = false) String isbn) {
    if (isbn == null) {
      return ResponseEntity.ok(libraryService.readBooks());
    }
    return ResponseEntity.ok(libraryService.readBook(isbn));
  }

  @GetMapping("/book/{bookId}")
  public ResponseEntity<Book> readBook(@PathVariable String bookId) {
    return ResponseEntity.ok(libraryService.readBookById(bookId));
  }

  @PostMapping("/book")
  public ResponseEntity<Book> createBook(@RequestBody BookCreationRequest request) {
    return ResponseEntity.ok(libraryService.createBook(request));
  }

  @DeleteMapping("/book/{bookId}")
  public ResponseEntity<Void> deleteBook(@PathVariable String bookId) {
    libraryService.deleteBook(bookId);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/member")
  public ResponseEntity<Member> createMember(@RequestBody MemberCreationRequest request) {
    return ResponseEntity.ok(libraryService.createMember(request));
  }

  @GetMapping("/member")
  public ResponseEntity<List<Member>> listAllMembers() {
    return ResponseEntity.ok(libraryService.findAllMembers());
  }

  @PatchMapping("/member/{memberId}")
  public ResponseEntity<Member> updateMember(
      @RequestBody MemberCreationRequest request, @PathVariable String memberId) {
    return ResponseEntity.ok(libraryService.updateMember(memberId, request));
  }

  @PostMapping("/book/lend")
  public ResponseEntity<List<String>> lendABook(@RequestBody BookLendRequest bookLendRequests) {
    return ResponseEntity.ok(libraryService.lendABook(bookLendRequests));
  }

  @PostMapping("/author")
  public ResponseEntity<Author> createAuthor(@RequestBody AuthorCreationRequest request) {
    return ResponseEntity.ok(libraryService.createAuthor(request));
  }

  @GetMapping("/author")
  public ResponseEntity<List<Author>> listAllAuthors() {
    return ResponseEntity.ok(libraryService.findAllAuthors());
  }
}
