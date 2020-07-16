package com.ShoppingBackEnd.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Data
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "description")
    private String desc;

    @Column(name = "availableQuantity")
    private int availableQuantity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_id", referencedColumnName = "id")
    private Set<ProductAttribute> prodAttributeList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_id", referencedColumnName = "id")
    private Set<prodImages> prodImagesList = new HashSet<>();

    @Column(name = "sec_id")
    private Long sec_id;

    @Column(name = "cat_id")
    private Long cat_id;

    @Column(name = "brand_id")
    private Long brand_id;

    public Product() {
    }
}
