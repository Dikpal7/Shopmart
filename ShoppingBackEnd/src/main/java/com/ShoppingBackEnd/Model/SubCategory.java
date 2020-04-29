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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SubCategory", uniqueConstraints = { @UniqueConstraint(columnNames = { "subCategories" }) })
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long ID;

	private String subCategories;

	@JsonIgnore
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private MainCategory mainCategory;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sub_category_id", referencedColumnName = "ID")
	private Set<CategoryItems> categoryItems = new HashSet<>();

	public Set<CategoryItems> getCategoryItems() {
		return categoryItems;
	}

	public void setCategoryItems(Set<CategoryItems> categoryItems) {
		this.categoryItems = categoryItems;
	}

	public String getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(String subCategories) {
		this.subCategories = subCategories;
	}

}
