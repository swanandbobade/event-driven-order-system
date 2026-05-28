package com.productservice.Service;

import com.productservice.Model.ProductDto;
import com.productservice.Resource.ProductResource;

public interface ProductService {

    ProductResource addProduct(ProductDto product);
    ProductResource updateProduct(Long id, ProductDto product);
    String deleteProduct(Long id);
    ProductResource getProduct(Long id);
}
