package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingBackEnd.Model.CategoryItems;

@Repository
public interface ProductRepository extends JpaRepository<CategoryItems, Long> {

}
