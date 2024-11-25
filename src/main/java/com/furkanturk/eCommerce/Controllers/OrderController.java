package com.furkanturk.eCommerce.Controllers;

import com.furkanturk.eCommerce.Models.Order;
import com.furkanturk.eCommerce.Models.OrderItem;
import com.furkanturk.eCommerce.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody List<OrderItem> items) {
        return orderService.createOrder(items);
    }
}
