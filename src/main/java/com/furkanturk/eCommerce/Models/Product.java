package com.furkanturk.eCommerce.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    private Integer stock;



    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="supplier_id",nullable = false)
    private Supplier supplier;

}
