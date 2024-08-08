package com.example.livros.controller;

import com.example.livros.dto.BookOrderDTO;
import com.example.livros.model.BookOrder;
import com.example.livros.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class BookOrderController {

    @Autowired
    private BookOrderService orderService;

    @GetMapping
    public List<BookOrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookOrderDTO> getOrderById(@PathVariable Long id) {
        Optional<BookOrderDTO> order = orderService.getOrderById(id);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public BookOrderDTO createOrder(@RequestBody BookOrderDTO bookOrderDTO) {
        return orderService.saveOrder(bookOrderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
