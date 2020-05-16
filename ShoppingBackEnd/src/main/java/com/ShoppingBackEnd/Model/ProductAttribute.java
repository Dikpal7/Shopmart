package com.ShoppingBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "ProductAttribute")
public class ProductAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "keyName", unique = true, nullable = false)
	private String keyName;

	@Column(name = "valueName", unique = true, nullable = false)
	private String valueName;

	@JsonIgnore
	@Column(name = "prod_id")
	private Long prod_id;

	@JsonIgnore
	@Column(name = "cat_id")
	private Long cat_id;

	@JsonIgnore
	@Column(name = "brand_id")
	private Long brand_id;

}
