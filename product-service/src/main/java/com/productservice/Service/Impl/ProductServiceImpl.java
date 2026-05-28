package com.productservice.Service.Impl;

import com.productservice.Mapper.ProductMapper;
import com.productservice.Entity.Product;
import com.productservice.Model.ProductDto;
import com.productservice.Repository.ProductRepository;
import com.productservice.Resource.ProductResource;
import com.productservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductResource addProduct(ProductDto product) {

        Product entity = productMapper.toEntity(product);
        Product savedProduct = productRepository.save(entity);
        return productMapper.toResponse(savedProduct);

    }

    @Override
    public ProductResource updateProduct(Long id, ProductDto product) {

        Product entity = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        entity.setProductName(product.getProductName());
        entity.setCategory(product.getCategory());
        entity.setProductPrice(product.getProductPrice());
        entity.setQuantity(product.getQuantity());

        Product updatedProduct = productRepository.save(entity);

        return productMapper.toResponse(updatedProduct);
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepository
                .findByProductIdAndIsDeletedFalse(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        if (Boolean.TRUE.equals(product.getIsDeleted())) {
            throw new RuntimeException("Product already deleted");
        }

        product.setIsDeleted(true);

        productRepository.save(product);

        return "Product deleted successfully";
    }

    @Override
    public ProductResource getProduct(Long id) {
        Product product = productRepository.findByProductIdAndIsDeletedFalse(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        return productMapper.toResponse(product);
    }
}
