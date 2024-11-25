package com.furkanturk.eCommerce.Services;

import com.furkanturk.eCommerce.Models.Order;
import com.furkanturk.eCommerce.Models.OrderItem;
import com.furkanturk.eCommerce.Models.Product;
import com.furkanturk.eCommerce.Repositories.OrderItemRepository;
import com.furkanturk.eCommerce.Repositories.OrderRepository;
import com.furkanturk.eCommerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService  {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order createOrder(List<OrderItem> items){
        Order order=new Order();
        order.setOrderDate(LocalDate.now());
        orderRepository.save(order);

        for(OrderItem item:items){
            Product product=productRepository.findById(item.getProduct().getId())
                    .orElseThrow(()->new RuntimeException("Product not found"));

            if(product.getStock()<item.getQuantity()){
                throw new RuntimeException("Insufficient stock for product"+product.getName());
            }

            product.setStock(product.getStock()-item.getQuantity());
            productRepository.save(product);

            item.setOrder(order);
            orderItemRepository.save(item);
        }
        return order;
    }



}
