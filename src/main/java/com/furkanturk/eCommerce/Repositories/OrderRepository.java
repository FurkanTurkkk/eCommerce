package com.furkanturk.eCommerce.Repositories;

import com.furkanturk.eCommerce.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
