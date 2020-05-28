package com.ShoppingBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingBackEnd.Model.Product;
import com.ShoppingBackEnd.Repository.ProductRepo;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.DtoProduct;

@Service
public class AdminService {

	@Autowired
	ProductRepo _prodRepo;

	public ResponseEntity<ApiResponse> addProduct(DtoProduct dtoProduct) {

		try {
			Product product = new Product(dtoProduct.getProduct(), dtoProduct.getPrice(),
					dtoProduct.getDesc(), dtoProduct.getAvailableQuantity(), dtoProduct.getProdAttributeList(),
					dtoProduct.getProdImagesList(), dtoProduct.getSec_id(), dtoProduct.getCat_id(),
					dtoProduct.getBrand_id());

			_prodRepo.save(product);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product inserted successfully!"), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}
