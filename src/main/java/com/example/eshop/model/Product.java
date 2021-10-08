package com.example.eshop.model;

public class Product {
	private String id;
	private String productName;
	private String[] features;
	private String price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String[] getFeatures() {
		return features;
	}
	public void setFeatures(String[] features) {
		this.features = features;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
