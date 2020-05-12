package com.ShoppingBackEnd.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "product", nullable = false)
	private String product;

	@Column(name = "price", nullable = false)
	private String price;

	@Column(name = "description")
	private String desc;

	@Column(name = "availableQuantity")
	private String availableQuantity;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_id", referencedColumnName = "id")
	private Set<ProductAttribute> prodAttributeList = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_id", referencedColumnName = "id")
	private Set<prodImages> prodImagesList = new HashSet<>();

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(String availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Set<ProductAttribute> getProdAttributeList() {
		return prodAttributeList;
	}

	public void setProdAttributeList(Set<ProductAttribute> prodAttributeList) {
		this.prodAttributeList = prodAttributeList;
	}

	public Set<prodImages> getProdImagesList() {
		return prodImagesList;
	}

	public void setProdImagesList(Set<prodImages> prodImagesList) {
		this.prodImagesList = prodImagesList;
	}

}
