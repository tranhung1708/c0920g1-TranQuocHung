package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.OrderBook;

public interface OrderBookRepository extends JpaRepository<OrderBook , Long> {
}
