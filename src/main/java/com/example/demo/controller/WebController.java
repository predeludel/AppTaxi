package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/")
    public String client() {
        return "client.html";
    }

    @GetMapping("/driver")
    public ModelAndView driver() {
        ModelAndView modelAndView = new ModelAndView("driver");
        modelAndView.addObject("orders", orderRepository.findAllByStatus(true));
        return modelAndView;
    }
    @GetMapping("/api/orders/{id}/status/{status}")
    public ModelAndView updateStatus(@PathVariable Long id, @PathVariable("status") boolean status) {
        if (orderRepository.findById(id).isPresent()) {
            Order oldOrder = orderRepository.findById(id).get();
            oldOrder.setStatus(status);
            orderRepository.save(oldOrder);
            return driver();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
