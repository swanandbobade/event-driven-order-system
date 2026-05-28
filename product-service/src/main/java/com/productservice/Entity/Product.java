package com.productservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String category;
    private Double productPrice;
    private Integer quantity;
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}
