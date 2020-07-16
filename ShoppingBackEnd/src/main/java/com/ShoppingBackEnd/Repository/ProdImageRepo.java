package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingBackEnd.Model.prodImages;

@Repository
public interface ProdImageRepo extends JpaRepository<prodImages, Long> {

}
