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

	public ProductAttribute(String keyName, String valueName, Long prod_id) {
		super();
		this.keyName = keyName;
		this.valueName = valueName;
		this.prod_id = prod_id;
	}

	public ProductAttribute() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "keyName", nullable = false)
	private String keyName;

	@Column(name = "valueName", nullable = false)
	private String valueName;

	@JsonIgnore
	@Column(name = "prod_id")
	private Long prod_id;

}
