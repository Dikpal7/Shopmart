package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingBackEnd.Model.CategoryItems;

public interface CategoryRepo extends JpaRepository<CategoryItems, Long> {

}
