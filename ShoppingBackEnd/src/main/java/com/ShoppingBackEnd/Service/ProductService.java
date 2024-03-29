package com.ShoppingBackEnd.Service;

import com.ShoppingBackEnd.Model.Brand;
import com.ShoppingBackEnd.Model.Category;
import com.ShoppingBackEnd.Model.Product;
import com.ShoppingBackEnd.Model.Section;
import com.ShoppingBackEnd.Repository.BrandRepo;
import com.ShoppingBackEnd.Repository.CategoryRepo;
import com.ShoppingBackEnd.Repository.ProductRepo;
import com.ShoppingBackEnd.Repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    SectionRepo _sectionRepo;
    @Autowired
    CategoryRepo _catRepo;
    @Autowired
    BrandRepo _brandRepo;
    @Autowired
    ProductRepo _prodRepo;

    public List<Section> getSections() {
        return _sectionRepo.findAll();
    }

    public List<Category> getCategories() {
        return _catRepo.findAll();
    }

    public List<Brand> getBrands() {
        return _brandRepo.findAll();
    }

    public List<Product> getAllProduct() {
        return _prodRepo.findAll();
    }

}
