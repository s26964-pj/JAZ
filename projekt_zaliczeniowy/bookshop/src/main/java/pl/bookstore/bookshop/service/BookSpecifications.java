package pl.bookstore.bookshop.service;

import org.springframework.data.jpa.domain.Specification;
import pl.bookstore.bookshop.model.Book;
import pl.bookstore.model.BookDetails;

public class BookSpecifications {
    public static Specification<Book> hasGenre(String genre) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("genre"), genre);
    }

    public static Specification<Book> hasPriceLessThanOrEqualTo(Double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Book> isAvailable(Boolean available) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("available"), available);
    }
}
