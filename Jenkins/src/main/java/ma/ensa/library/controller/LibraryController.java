package ma.ensa.library.controller;

import ma.ensa.library.entity.Book;
import ma.ensa.library.entity.Loan;
import ma.ensa.library.entity.Member;
import ma.ensa.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;
    // Test d'automatisation Jenkins
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @PostMapping("/members")
    public Member addMember(@RequestBody Member member) {
        return libraryService.addMember(member);
    }

    @PostMapping("/borrow/{bookId}/{memberId}")
    public Loan borrowBook(@PathVariable Long bookId, @PathVariable Long memberId) {
        return libraryService.borrowBook(bookId, memberId);
    }
}