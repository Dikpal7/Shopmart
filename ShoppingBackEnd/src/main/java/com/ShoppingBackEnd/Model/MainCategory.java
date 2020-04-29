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
import javax.validation.constraints.NotBlank;

import com.ShoppingBackEnd.Model.Audit.DateAudit;

@Entity
@Table(name = "MainCategory", uniqueConstraints = { @UniqueConstraint(columnNames = { "mainCategory" }) })
public class MainCategory extends DateAudit {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long ID;

	@NotBlank
	private String mainCategory;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "main_category_id", referencedColumnName = "ID")
	private Set<SubCategory> subCategoryList = new HashSet<>();

	public Set<SubCategory> getSubCategoryList() {
		return subCategoryList;
	}

	public void setSubCategoryList(Set<SubCategory> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}

	public String getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

}
