package ma.ensa.library;

import ma.ensa.library.entity.Book;
import ma.ensa.library.entity.Member;
import ma.ensa.library.repository.BookRepository;
import ma.ensa.library.repository.LoanRepository;
import ma.ensa.library.repository.MemberRepository;
import ma.ensa.library.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryServiceTest {

    @Autowired
    private LibraryService libraryService;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private LoanRepository loanRepository;

    @Test
    void testAddBook() {
        Book book = new Book(1L, "Jenkins Guide", "John Doe", "Tech", true);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book created = libraryService.addBook(book);

        assertNotNull(created);
        assertEquals("Jenkins Guide", created.getTitle());
    }

    // Test simple pour vérifier que le contexte se charge
    @Test
    void contextLoads() {
    }
}