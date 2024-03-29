package com.ShoppingBackEnd.payload;

import java.util.Set;

import com.ShoppingBackEnd.Model.ProductAttribute;
import com.ShoppingBackEnd.Model.prodImages;

import lombok.Data;

@Data
public class DtoProduct {

	private Long id;
	private String product;
	private String price;
	private Long cat_id;
	private Long sec_id;
	private Long brand_id;
	private String desc;
	private Integer availableQuantity;
	private Set<ProductAttribute> prodAttributeList;
	private Set<prodImages> prodImagesList;
}
