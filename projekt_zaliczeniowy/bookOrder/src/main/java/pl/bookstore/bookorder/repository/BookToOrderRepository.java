package pl.bookstore.bookorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookToOrderRepository extends JpaRepository<BookToOrderRepository, UUID> {
}
