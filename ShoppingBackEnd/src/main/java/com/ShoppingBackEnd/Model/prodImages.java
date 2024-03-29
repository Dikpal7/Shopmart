package com.ShoppingBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("ALL")
@Entity
@Data
@Table(name = "ProdImage")
public class prodImages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "imageUrl", nullable = false)
	private String imageUrl;

	@JsonIgnore
	@Column(name = "prod_id")
	private Long prod_id;
}
