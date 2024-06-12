package pl.bookstore.bookshop.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.bookstore.bookshop.book.additional.Author;
import pl.bookstore.bookshop.book.additional.BookVisitor;
import pl.bookstore.model.BookType;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;

    @ManyToOne
    private Author author;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    private Integer pages;
    private Double price;

    @OneToOne
    private BookVisitor visitor;
}
