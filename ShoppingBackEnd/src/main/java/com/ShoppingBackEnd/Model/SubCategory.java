package com.ShoppingBackEnd.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SubCategory", uniqueConstraints = { @UniqueConstraint(columnNames = { "subCategories" }) })
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private Long subCatId;

	private String subCategories;

	@OneToMany(targetEntity = CategoryItems.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "subCategoryId")
	private List<CategoryItems> categoryItems;

	public String getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(String subCategories) {
		this.subCategories = subCategories;
	}

}
