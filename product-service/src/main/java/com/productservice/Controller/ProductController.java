package com.productservice.Controller;

import com.productservice.Model.ProductDto;
import com.productservice.Resource.ProductResource;
import com.productservice.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    // Add Product
    @PostMapping
    public ResponseEntity<ProductResource> addProduct(
            @Valid @RequestBody ProductDto product) {
        return ResponseEntity.ok(service.addProduct(product));
    }

    // Get Product By Id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResource> getProductById(
            @PathVariable("id") Long productId) {

        return ResponseEntity.ok(service.getProduct(productId));
    }

    // Update Product
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResource> updateProductById(
            @PathVariable("id") Long productId,
            @Valid @RequestBody ProductDto product) {

        return ResponseEntity.ok(service.updateProduct(productId, product));
    }

    // Delete Product
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeProductById(
            @PathVariable("id") Long productId) {
        return ResponseEntity.ok(service.deleteProduct(productId));
    }

}
