package com.ShoppingBackEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingBackEnd.Model.Brand;
import com.ShoppingBackEnd.Model.Category;
import com.ShoppingBackEnd.Model.Product;
import com.ShoppingBackEnd.Model.Section;
import com.ShoppingBackEnd.Service.AdminService;
import com.ShoppingBackEnd.Service.ProductService;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.CommonResponse;
import com.ShoppingBackEnd.payload.DtoProduct;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService _productService;
	
	@Autowired
	AdminService _adminService;

	@GetMapping("/section")
	public ResponseEntity<CommonResponse<List<Section>>> getSections() {
		try {
			return new ResponseEntity<CommonResponse<List<Section>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getSections()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<Section>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/category")
	public ResponseEntity<CommonResponse<List<Category>>> getCategories() {
		try {
			return new ResponseEntity<CommonResponse<List<Category>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getCategories()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<Category>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/brand")
	public ResponseEntity<CommonResponse<List<Brand>>> getBrands() {
		try {
			return new ResponseEntity<CommonResponse<List<Brand>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getBrands()), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<Brand>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}
	
}
