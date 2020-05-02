package com.ShoppingBackEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingBackEnd.Model.CategoryItems;
import com.ShoppingBackEnd.Model.MainCategory;
import com.ShoppingBackEnd.Model.SubCategory;
import com.ShoppingBackEnd.Service.ProductService;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.CommonResponse;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService _productService;

	@GetMapping("/mainCategory")
	public ResponseEntity<CommonResponse<List<MainCategory>>> getMainCategory() {
		try {
			return new ResponseEntity<CommonResponse<List<MainCategory>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getMainCategory()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<MainCategory>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/subCategory")
	public ResponseEntity<CommonResponse<List<SubCategory>>> getSubCategory() {
		try {
			return new ResponseEntity<CommonResponse<List<SubCategory>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getSubCategory()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<SubCategory>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/categoryItems")
	public ResponseEntity<CommonResponse<List<CategoryItems>>> getCategoryItems() {
		try {
			return new ResponseEntity<CommonResponse<List<CategoryItems>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getCategoryItems()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<CategoryItems>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}
}
