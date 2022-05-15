package com.example.demo.controller;


import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public Iterable<Order> read() {
        return orderRepository.findAll();
    }

    @PostMapping("/orders")
    public Order create(@RequestBody Order order){
        return orderRepository.save(order);

    }
    @DeleteMapping("/orders/{id}")
    public Boolean delete(@PathVariable Long id){
        if (orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
    @PutMapping("/orders")
    public Order update(@RequestBody Order newOrder){
        if (orderRepository.findById(newOrder.getId()).isPresent()){
            Order oldOrder = orderRepository.findById(newOrder.getId()).get();
            oldOrder.setStatus(newOrder.getStatus());
            oldOrder.setPlaceStart(newOrder.getPlaceStart());
            oldOrder.setPlaceFinish(newOrder.getPlaceFinish());
            oldOrder.setIdClient(newOrder.getIdClient());
            oldOrder.setIdDriver(newOrder.getIdDriver());
            oldOrder.setPrice(newOrder.getPrice());
            return orderRepository.save(oldOrder);
        } else{
            return orderRepository.save(newOrder);
        }

    }
}
