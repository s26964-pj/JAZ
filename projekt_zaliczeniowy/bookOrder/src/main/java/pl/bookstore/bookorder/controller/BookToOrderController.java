package pl.bookstore.bookorder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.bookstore.api.OrderReportApi;
import pl.bookstore.model.SendOrderReportRequestInner;

import java.util.List;

@RestController
public class BookToOrderController implements OrderReportApi {
    @Override
    public ResponseEntity<Void> sendOrderReport(List<SendOrderReportRequestInner> sendOrderReportRequestInner) {
        //TODO dodanie do bazy
        return ResponseEntity.noContent().build();
    }
}
