package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingBackEnd.Model.Brand;

public interface BrandRepo extends JpaRepository<Brand, Long> {

}
