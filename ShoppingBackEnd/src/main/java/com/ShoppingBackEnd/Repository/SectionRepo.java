package com.ShoppingBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShoppingBackEnd.Model.Section;

@Repository
public interface SectionRepo extends JpaRepository<Section, Long> {

}
