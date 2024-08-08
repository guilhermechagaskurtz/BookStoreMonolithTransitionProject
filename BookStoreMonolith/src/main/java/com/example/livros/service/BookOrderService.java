package com.example.livros.service;

import com.example.livros.dto.BookOrderDTO;
import com.example.livros.model.BookOrder;
import com.example.livros.repository.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookOrderService {

    @Autowired
    private BookOrderRepository orderRepository;

    public List<BookOrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookOrderDTO> getOrderById(Long id) {
        return orderRepository.findById(id).map(this::convertToDTO);
    }

    public BookOrderDTO saveOrder(BookOrderDTO orderDTO) {
        BookOrder order = convertToEntity(orderDTO);
        BookOrder savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private BookOrderDTO convertToDTO(BookOrder order) {
        BookOrderDTO orderDTO = new BookOrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setBookTitle(order.getBookTitle());
        orderDTO.setQuantity(order.getQuantity());
        orderDTO.setTotalPrice(order.getTotalPrice());
        return orderDTO;
    }

    private BookOrder convertToEntity(BookOrderDTO orderDTO) {
        BookOrder order = new BookOrder();
        order.setId(orderDTO.getId());
        order.setBookTitle(orderDTO.getBookTitle());
        order.setQuantity(orderDTO.getQuantity());
        order.setTotalPrice(orderDTO.getTotalPrice());
        return order;
    }
}
