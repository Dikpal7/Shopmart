package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingBackEnd.Model.SubCategory;

@Repository
public interface SubCatRepo extends JpaRepository<SubCategory, Long> {

}
