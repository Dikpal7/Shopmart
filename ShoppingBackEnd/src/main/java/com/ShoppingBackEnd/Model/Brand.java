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

@Entity
@Data
@Table(name = "Brand")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "brand", unique = true)
	private String brand;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private Set<Product> productList = new HashSet<>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private Set<ProductAttribute> prodAttributeList = new HashSet<>();

}
