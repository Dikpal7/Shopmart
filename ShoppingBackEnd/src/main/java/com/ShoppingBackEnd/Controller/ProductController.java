package com.ShoppingBackEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingBackEnd.Model.Brand;
import com.ShoppingBackEnd.Model.Category;
import com.ShoppingBackEnd.Model.Section;
import com.ShoppingBackEnd.Service.ProductService;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.CommonResponse;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService _productService;

	@GetMapping("/section")
	public ResponseEntity<CommonResponse<List<Section>>> getMainCategory() {
		try {
			return new ResponseEntity<CommonResponse<List<Section>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getMainCategory()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<Section>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/category")
	public ResponseEntity<CommonResponse<List<Category>>> getSubCategory() {
		try {
			return new ResponseEntity<CommonResponse<List<Category>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getSubCategory()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<Category>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/brands")
	public ResponseEntity<CommonResponse<List<Brand>>> getCategoryItems() {
		try {
			return new ResponseEntity<CommonResponse<List<Brand>>>(
					new CommonResponse<>(new ApiResponse(true, "success"), _productService.getCategoryItems()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<CommonResponse<List<Brand>>>(
					new CommonResponse<>(new ApiResponse(false, e.getMessage()), null), HttpStatus.NOT_FOUND);
		}
	}
}
