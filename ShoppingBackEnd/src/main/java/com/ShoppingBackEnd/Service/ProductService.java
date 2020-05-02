package com.ShoppingBackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingBackEnd.Model.CategoryItems;
import com.ShoppingBackEnd.Model.MainCategory;
import com.ShoppingBackEnd.Model.SubCategory;
import com.ShoppingBackEnd.Repository.CategoryRepo;
import com.ShoppingBackEnd.Repository.MainCatRepo;
import com.ShoppingBackEnd.Repository.SubCatRepo;

@Service
public class ProductService {

	@Autowired
	MainCatRepo _mainRepo;

	@Autowired
	SubCatRepo _subRepo;

	@Autowired
	CategoryRepo _catRepo;

	public List<MainCategory> getMainCategory() {
		return _mainRepo.findAll();
	}

	public List<SubCategory> getSubCategory() {
		return _subRepo.findAll();
	}

	public List<CategoryItems> getCategoryItems() {
		return _catRepo.findAll();
	}
}
