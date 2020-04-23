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

import com.ShoppingBackEnd.Model.Audit.DateAudit;

@SuppressWarnings("serial")
@Entity
@Table(name = "MainCategory", uniqueConstraints = { @UniqueConstraint(columnNames = { "mainCategory" }) })
public class MainCategory extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private Long mainCatId;

	private String mainCategory;

	@OneToMany(targetEntity = SubCategory.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "mainCategoryId")

	private List<SubCategory> subCategoryList;

	public String getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

}
