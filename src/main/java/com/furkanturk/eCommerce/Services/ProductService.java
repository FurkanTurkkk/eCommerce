package com.furkanturk.eCommerce.Services;

import com.furkanturk.eCommerce.Models.Product;
import com.furkanturk.eCommerce.Repositories.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product createProduct(Product product){
        Optional<Product> existingProduct = productRepository.findByName(product.getName());

        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            if(!productToUpdate.getPrice().equals(product.getPrice())){
                throw new IllegalArgumentException("Aynı ürün farklı bir fiyatla eklenemez!");
            }
            productToUpdate.setStock(productToUpdate.getStock() + product.getStock());
            return productRepository.save(productToUpdate);
        } else {

            return productRepository.save(product);
        }
    }

    public Optional<Product> getProductById(Long id){
        Optional<Product> product=productRepository.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Product Not Found!");
        }
        return product;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public Optional<List<Product>> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
        System.out.print("Ürün Başarıyla Silindi...");
    }

}
