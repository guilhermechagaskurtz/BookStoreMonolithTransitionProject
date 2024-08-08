package com.example.BookStorePedidosMicrosservice.service;

import com.example.BookStorePedidosMicrosservice.model.BookOrder;
import com.example.BookStorePedidosMicrosservice.repository.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookOrderService {

    @Autowired
    private BookOrderRepository bookOrderRepository;

    public List<BookOrder> getAllBookOrders() {
        return bookOrderRepository.findAll();
    }

    public Optional<BookOrder> getBookOrderById(Long id) {
        return bookOrderRepository.findById(id);
    }

    public BookOrder saveOrder(BookOrder bookOrder) {
        return bookOrderRepository.save(bookOrder);
    }

    public void deleteBookOrder(Long id) {
        bookOrderRepository.deleteById(id);
    }
}