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
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "Section", uniqueConstraints = { @UniqueConstraint(columnNames = { "section" }) })
public class Section extends DateAudit {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;


	@NotBlank
	private String section;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sec_id", referencedColumnName = "id")
	private Set<Category> categoryList = new HashSet<>();


	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sec_id", referencedColumnName = "id")
	private Set<Brand> brandList = new HashSet<>();


	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sec_id", referencedColumnName = "id")
	private Set<Product> productList = new HashSet<>();

}
