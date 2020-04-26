package com.ShoppingBackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingBackEnd.Model.CategoryItems;
import com.ShoppingBackEnd.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository _productRepo;

	public List<CategoryItems> getCategoryitems() {
		return _productRepo.findAll();
	}

}
