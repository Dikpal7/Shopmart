package com.ShoppingBackEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingBackEnd.Model.CategoryItems;
import com.ShoppingBackEnd.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService _productService;

	@GetMapping("/getCategory")
	public List<CategoryItems> getCategoryitems() {
		return _productService.getCategoryitems();
	}

}
