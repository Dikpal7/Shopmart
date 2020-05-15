package com.ShoppingBackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingBackEnd.Model.Brand;
import com.ShoppingBackEnd.Model.Category;
import com.ShoppingBackEnd.Model.Section;
import com.ShoppingBackEnd.Repository.BrandRepo;
import com.ShoppingBackEnd.Repository.CategoryRepo;
import com.ShoppingBackEnd.Repository.SectionRepo;

@Service
public class ProductService {

	@Autowired
	SectionRepo _mainRepo;

	@Autowired
	CategoryRepo _subRepo;

	@Autowired
	BrandRepo _catRepo;

	public List<Section> getMainCategory() {
		return _mainRepo.findAll();
	}

	public List<Category> getSubCategory() {
		return _subRepo.findAll();
	}

	public List<Brand> getCategoryItems() {
		return _catRepo.findAll();
	}
}
