package com.furkanturk.eCommerce.Controllers;

import com.furkanturk.eCommerce.Models.Order;
import com.furkanturk.eCommerce.Models.OrderProduct;
import com.furkanturk.eCommerce.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Order> createOrder(@RequestBody List<OrderProduct> items) {
        try{
            Order createOrder=orderService.createOrder(items);
            return ResponseEntity.ok(createOrder);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
