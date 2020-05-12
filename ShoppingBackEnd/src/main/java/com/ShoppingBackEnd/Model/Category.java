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

@Entity
@Table(name = "Category", uniqueConstraints = { @UniqueConstraint(columnNames = { "category" }) })
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String category;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Set<Brand> brandsList = new HashSet<>();

	public Set<Brand> getBrandsList() {
		return brandsList;
	}

	public void setBrandsList(Set<Brand> brandsList) {
		this.brandsList = brandsList;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Set<MasterSpecification> masterSpecList = new HashSet<>();

	public Set<MasterSpecification> getMasterSpecList() {
		return masterSpecList;
	}

	public void setMasterSpecList(Set<MasterSpecification> masterSpecList) {
		this.masterSpecList = masterSpecList;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Set<Product> productList = new HashSet<>();

	public Set<Product> getProductList() {
		return productList;
	}

	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Set<ProductAttribute> prodAttributeList = new HashSet<>();

	public Set<ProductAttribute> getProdAttributeList() {
		return prodAttributeList;
	}

	public void setProdAttributeList(Set<ProductAttribute> prodAttributeList) {
		this.prodAttributeList = prodAttributeList;
	}

}
