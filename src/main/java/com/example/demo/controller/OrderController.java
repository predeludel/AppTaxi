package com.example.demo.controller;


import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public Iterable<Order> read() {
        return orderRepository.findAll();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @PostMapping("/orders")
    public Order create(@RequestBody Order order) {
        order.setPrice(getRandomNumber(100, 500));
        order.setStatus(true);
        return orderRepository.save(order);

    }

    @DeleteMapping("/orders/{id}")
    public Boolean delete(@PathVariable Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
