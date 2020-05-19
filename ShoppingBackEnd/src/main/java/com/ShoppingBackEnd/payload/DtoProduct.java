package com.ShoppingBackEnd.payload;

import java.util.Set;

import com.ShoppingBackEnd.Model.ProductAttribute;
import com.ShoppingBackEnd.Model.prodImages;

import lombok.Data;

@Data
public class DtoProduct {

	private String productName;
	private String price;
	private Long prodCatId;
	private Long prodSectionId;
	private Long prodBrandId;
	private String description;
	private Integer quantity;
	private Set<ProductAttribute> prodAttributeList;
	private Set<prodImages> prodImagesList;
}
