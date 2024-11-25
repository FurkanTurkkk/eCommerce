package com.furkanturk.eCommerce.Controllers;

import com.furkanturk.eCommerce.Models.Category;
import com.furkanturk.eCommerce.Models.Product;
import com.furkanturk.eCommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product product1=productService.createProduct(product);
        return ResponseEntity.ok(product1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id){
        Optional<Product> product=productService.getProductById(id);
        if(product.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products=productService.getAllProduct();
        if(products==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Ürünler bulunamadı").build();
        }
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        if(productService.getProductById(id).isPresent()){
            productService.deleteProductById(id);
            return ResponseEntity.noContent().build();
        }

        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam Long categoryId){
        Optional<List<Product>> products=productService.getProductsByCategory(categoryId);

        if(products.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            ResponseEntity.ok().body(products);
            return ResponseEntity.ok().build();
        }

    }

}
