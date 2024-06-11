package com.HibernateInDepthTuts.Entity;

import java.util.Arrays;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String productTitle;
	@Column(nullable = true)
	private String description;
	
	@NotNull
	private long price;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	

	public Products() {
		
	}

	public Products(@NotNull String productTitle, String description, @NotNull long price, byte[] image) {
		super();
		this.productTitle = productTitle;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public Products(long id, @NotNull String productTitle, String description, @NotNull long price, byte[] image) {
		super();
		this.id = id;
		this.productTitle = productTitle;
		this.description = description;
		this.price = price;
		this.image = image;
	}
	
	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", productTitle=" + productTitle + ", description=" + description + ", price=" + price
				+ ", image=" + Arrays.toString(image) + "]";
	}
	
	
}
