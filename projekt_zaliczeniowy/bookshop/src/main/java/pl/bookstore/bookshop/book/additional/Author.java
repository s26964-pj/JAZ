package pl.bookstore.bookshop.book.additional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.bookstore.bookshop.book.Book;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;

    @OneToMany
    private List<Book> book;
}
