package com.example.demo.controller;

import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        ModelAndView modelAndView = new ModelAndView("driver.html");
        modelAndView.addObject("orders", orderRepository.findAll());
        return modelAndView;
    }
}
