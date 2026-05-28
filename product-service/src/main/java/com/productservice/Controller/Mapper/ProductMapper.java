package com.productservice.Controller.Mapper;

import com.productservice.Entity.Product;
import com.productservice.Model.ProductDto;
import com.productservice.Resource.ProductResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResource toResponse(Product product);
    Product toEntity(ProductDto product);

}
