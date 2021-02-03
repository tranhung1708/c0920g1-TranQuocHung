package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.OrderBook;
import vn.codegym.repository.OrderBookRepository;
import vn.codegym.service.OrderBookService;

@Service
public class OrderBookServiceImpl implements OrderBookService {
    @Autowired
    OrderBookRepository orderBookRepository;

    @Override
    public void save(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }

    @Override
    public OrderBook findById(long id) {
        return orderBookRepository.findById(id).orElse(null);
    }

    @Override
    public Long createId() {
        long code = 0;
        do {
            code = Math.round(Math.random()*100000);
        }while (code < 10000);
        return code;
    }

    @Override
    public void delete(OrderBook orderBook) {
        orderBookRepository.delete(orderBook);
    }

    @Override
    public boolean isEmpty(OrderBook orderBook) {
        return orderBookRepository.existsById(orderBook.getId());
    }
}
