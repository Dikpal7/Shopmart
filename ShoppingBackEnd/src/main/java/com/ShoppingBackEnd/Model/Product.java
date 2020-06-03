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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("ALL")
@Entity
@Data
@Table(name = "Product")
public class Product {

	public Product() {
	}

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
	private int availableQuantity;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_id", referencedColumnName = "id")
	private Set<ProductAttribute> prodAttributeList = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_id", referencedColumnName = "id")
	private Set<prodImages> prodImagesList = new HashSet<>();

	@JsonIgnore
	@Column(name = "sec_id")
	private Long sec_id;

	@JsonIgnore
	@Column(name = "cat_id")
	private Long cat_id;

	@JsonIgnore
	@Column(name = "brand_id")
	private Long brand_id;

}
