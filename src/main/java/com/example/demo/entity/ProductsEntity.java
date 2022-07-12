package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="users")
public class ProductsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="category_id")
	private Long categoryId;
	
	@Column(name ="product_name")
	private String productName;
	
	@Column(name ="category_name")
	private String categoryName;
	
	@Column(name ="product_price")
	private Long productPrice;
	
	@Column(name ="product_description")
	private String productDescription;
	
	@Column(name ="product_image")
	private String productImage;
	
	@Column(name ="product_discount")
	private Long productDiscount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Long getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Long productDiscount) {
		this.productDiscount = productDiscount;
	}

	public ProductsEntity(Long id, Long categoryId, String productName, String categoryName, Long productPrice,
			String productDescription, String productImage, Long productDiscount) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.productName = productName;
		this.categoryName = categoryName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productDiscount = productDiscount;
	}

	@Override
	public String toString() {
		return "ProductsEntity [id=" + id + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", categoryName=" + categoryName + ", productPrice=" + productPrice + ", productDescription="
				+ productDescription + ", productImage=" + productImage + ", productDiscount=" + productDiscount + "]";
	}

	public ProductsEntity() {
		super();
		
	}
	

}
