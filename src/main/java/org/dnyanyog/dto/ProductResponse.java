package org.dnyanyog.dto;

import org.dnyanyog.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductResponse {
	private String responseCode;
	private String responseMessage;
	private Integer id;

	private ProductRequest request;
	@Autowired
	private Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public ProductRequest getRequest() {
		return request;
	}

	public void setRequest(ProductRequest request) {
		this.request = request;
	}
	
	

}
