package com.ShoppingBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingBackEnd.Model.Product;
import com.ShoppingBackEnd.Model.ProductAttribute;
import com.ShoppingBackEnd.Repository.ProductRepo;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.DtoProduct;

@Service
public class AdminService {

	@Autowired
	ProductRepo _prodRepo;

	public ApiResponse addProduct(DtoProduct dtoProduct) {

		try {
			Product product = new Product();
			product.setProduct(dtoProduct.getProductName());
			product.setPrice(dtoProduct.getPrice());
			product.setAvailableQuantity(dtoProduct.getQuantity());
			product.setDesc(dtoProduct.getDescription());
			product.setSec_id(dtoProduct.getProdSectionId());
			product.setCat_id(dtoProduct.getProdCatId());
			product.setBrand_id(dtoProduct.getProdBrandId());
			product.setProdImagesList(dtoProduct.getProdImagesList());

			for (ProductAttribute prodAttribute : dtoProduct.getProdAttributeList()) {

				ProductAttribute prodAtb = new ProductAttribute();
				prodAtb.setBrand_id(dtoProduct.getProdBrandId());
				prodAtb.setCat_id(dtoProduct.getProdCatId());
				prodAtb.setProd_id(prodAttribute.getProd_id());
				prodAtb.setKeyName(prodAttribute.getKeyName());
				prodAtb.setValueName(prodAttribute.getValueName());
				product.getProdAttributeList().add(prodAtb);
			}

			_prodRepo.save(product);
			return new ApiResponse(true, "Product added successfully!");

		} catch (Exception e) {
			return new ApiResponse(false, e.getMessage());
		}
	}

}
