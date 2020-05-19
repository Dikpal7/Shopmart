package com.ShoppingBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingBackEnd.Model.Product;
import com.ShoppingBackEnd.Repository.ProductRepo;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.DtoProduct;

@Service
public class AdminService {

	@Autowired
	ProductRepo _prodRepo;

	public ApiResponse addProduct(DtoProduct dtoProduct) {

		try {
			Product product = new Product(dtoProduct.getProductName(), dtoProduct.getPrice(),
					dtoProduct.getDescription(), dtoProduct.getQuantity(), dtoProduct.getProdAttributeList(),
					dtoProduct.getProdImagesList(), dtoProduct.getProdSectionId(), dtoProduct.getProdCatId(),
					dtoProduct.getProdBrandId());

			_prodRepo.save(product);
			return new ApiResponse(true, "Product added successfully!");

		} catch (Exception e) {
			return new ApiResponse(false, e.getMessage());
		}
	}
}
