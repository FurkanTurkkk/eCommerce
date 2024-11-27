package com.furkanturk.eCommerce.Repositories;

import com.furkanturk.eCommerce.Models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderProduct,Long> {
}
