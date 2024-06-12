package pl.bookstore.bookorder.service;

import org.springframework.stereotype.Service;
import pl.bookstore.bookorder.repository.BookToOrderRepository;

@Service
public class BookToOrderService {
    private final BookToOrderRepository bookToOrderRepository;

    public BookToOrderService(BookToOrderRepository bookToOrderRepository) {
        this.bookToOrderRepository = bookToOrderRepository;
    }

}
