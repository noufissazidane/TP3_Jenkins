package ma.ensa.library.service;

import ma.ensa.library.entity.Book;
import ma.ensa.library.entity.Loan;
import ma.ensa.library.entity.Member;
import ma.ensa.library.repository.BookRepository;
import ma.ensa.library.repository.LoanRepository;
import ma.ensa.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryService {

    @Autowired private BookRepository bookRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private LoanRepository loanRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Loan borrowBook(Long bookId, Long memberId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Livre non trouvé"));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Membre non trouvé"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Livre déjà emprunté");
        }

        book.setAvailable(false);
        bookRepository.save(book);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loan.setLoanDate(LocalDate.now());

        return loanRepository.save(loan);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}