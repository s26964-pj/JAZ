package pl.bookstore.bookshop.book;

import org.springframework.stereotype.Service;
import pl.bookstore.model.BookDetails;
import pl.bookstore.model.BookRequest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper mapper;

    public BookService(BookRepository bookRepository, BookMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    public List<BookDetails> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(mapper::toDetails)
                .collect(Collectors.toList());
    }

    public BookDetails getBookById (UUID id) {
        return mapper.toDetails(bookRepository.getReferenceById(id));
    }

    public BookDetails addNewBook (BookRequest bookRequest) {
        Book entity = mapper.toEntity(bookRequest);
        bookRepository.save(entity);
        return mapper.toDetails(entity);
    }

    public void deleteBook (UUID id) {
        bookRepository.delete(bookRepository.getReferenceById(id));
    }

    public BookDetails updateBook (UUID id, BookRequest bookRequest) {
        Book existingBook = bookRepository.getReferenceById(id);

        Book updatedBook = mapper.toEntity(bookRequest);
        updatedBook.setId(existingBook.getId());
        bookRepository.save(updatedBook);

        return mapper.toDetails(updatedBook);
    }


}
