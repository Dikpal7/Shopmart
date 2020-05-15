package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingBackEnd.Model.ProductAttribute;

@Repository
public interface ProdAttributeRepo extends JpaRepository<ProductAttribute, Long> {

}
