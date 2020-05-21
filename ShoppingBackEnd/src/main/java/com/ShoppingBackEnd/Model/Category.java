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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "category", nullable = false)
	private String category;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Set<Brand> brandsList = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Set<MasterSpecification> masterSpecList = new HashSet<>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Set<Product> productList = new HashSet<>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Set<ProductAttribute> prodAttributeList = new HashSet<>();
	
	@Column(name = "sec_id")
	private Long sec_id;

}
