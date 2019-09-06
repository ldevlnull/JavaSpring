package com.alexcompany.springsecurity.repository;

import com.alexcompany.springsecurity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByProductName(String productName);

    void deleteProductByProductName(String productName);
}