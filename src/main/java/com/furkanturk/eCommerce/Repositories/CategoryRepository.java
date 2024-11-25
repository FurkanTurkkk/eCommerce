package com.furkanturk.eCommerce.Repositories;

import com.furkanturk.eCommerce.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
