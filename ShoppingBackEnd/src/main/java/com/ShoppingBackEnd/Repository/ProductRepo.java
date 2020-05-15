package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingBackEnd.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
