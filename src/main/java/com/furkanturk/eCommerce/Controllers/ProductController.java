package com.furkanturk.eCommerce.Controllers;

import com.furkanturk.eCommerce.Models.Product;
import com.furkanturk.eCommerce.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product product1=productService.createProduct(product);
        return ResponseEntity.ok(product1);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products=productService.getAllProduct();
        if(products==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

}
