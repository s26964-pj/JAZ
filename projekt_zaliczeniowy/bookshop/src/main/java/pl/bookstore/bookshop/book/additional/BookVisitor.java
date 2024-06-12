package pl.bookstore.bookshop.book.additional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.bookstore.bookshop.book.Book;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BookVisitor {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private Book book;

    private Integer visitorsCount;
}
