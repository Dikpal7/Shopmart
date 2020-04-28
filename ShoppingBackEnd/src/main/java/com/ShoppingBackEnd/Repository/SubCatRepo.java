package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingBackEnd.Model.SubCategory;

public interface SubCatRepo extends JpaRepository<SubCategory, Long> {

}
