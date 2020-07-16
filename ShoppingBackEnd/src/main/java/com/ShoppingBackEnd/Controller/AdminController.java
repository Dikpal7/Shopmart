package com.ShoppingBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingBackEnd.Service.AdminService;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.DtoProduct;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService _adminService;

	@PostMapping("/addProduct")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody DtoProduct dtoProduct) {
		return _adminService.addProduct(dtoProduct);
	}
}
