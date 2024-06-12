package pl.bookstore.bookshop.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.bookstore.api.BooksApi;
import pl.bookstore.model.BookDetails;
import pl.bookstore.model.BookRequest;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController implements BooksApi {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<BookDetails> addNewBook(BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.addNewBook(bookRequest));
    }

    @Override
    public ResponseEntity<Void> deleteBook(UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<BookDetails>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Override
    public ResponseEntity<BookDetails> getBookById(UUID id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @Override
    public ResponseEntity<BookDetails> updateBook(UUID id, BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.updateBook(id, bookRequest));
    }

    //TODO getMapping -> /book-order -> service.orderBook
}
