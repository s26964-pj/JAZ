package pl.bookstore.bookshop.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bookstore.bookshop.mapper.BookMapper;
import pl.bookstore.bookshop.model.Book;
import pl.bookstore.bookshop.model.BookVisitor;
import pl.bookstore.bookshop.repository.BookRepository;
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
    //TODO filterAndSortBooks
    public List<Book> filterAndSortBooks(String genre, Double maxPrice, Boolean available, String sortBy) {
        Specification<Book> spec = Specification.where(null);

        if (genre != null) {
            spec = spec.and(BookSpecifications.hasGenre(genre));
        }
        if (maxPrice != null) {
            spec = spec.and(BookSpecifications.hasPriceLessThanOrEqualTo(maxPrice));
        }
        if (available != null) {
            spec = spec.and(BookSpecifications.isAvailable(available));
        }

        Sort sort = Sort.by(sortBy != null ? sortBy : "id");

        return bookRepository.findAll(spec, sort);
    }
    //TODO incrementVisitCount
    @Transactional
    public void incrementVisitCount(UUID id) {
        Book book = bookRepository.getReferenceById(id);
        book.incrementVisitorCount();
        bookRepository.save(book);
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
        updatedBook.setBookId(existingBook.getBookId());
        bookRepository.save(updatedBook);

        return mapper.toDetails(updatedBook);
    }


}
