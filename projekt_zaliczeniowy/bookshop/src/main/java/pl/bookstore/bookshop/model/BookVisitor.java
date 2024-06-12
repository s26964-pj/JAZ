package pl.bookstore.bookshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.bookstore.bookshop.model.Book;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "bookVisitor_table")
public class BookVisitor {
    @Id
    @GeneratedValue
    private UUID bookVisitorId;

    @OneToOne
    @JoinColumn(name = "bookId")
    private Book book;

    private Integer visitorsCount;
}
