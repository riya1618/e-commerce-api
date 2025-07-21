package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.entity.Product;
import org.dnyanyog.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;


	public ProductResponse addProduct(ProductRequest request) {
		Product productTable = new Product();

		productTable.setName(request.getProductName());
		productTable.setQuantity(request.getQuantity());
		productTable.setPrice(request.getPrice());

		Product dataInsertedByValueRepoIncludingGeneratedValue = productRepo.save(productTable);
		ProductResponse response = new ProductResponse();
		response.setResponseCode("0000");
		response.setResponseMessage("Product Added Successfully");
		response.setRequest(request);
		response.setId(dataInsertedByValueRepoIncludingGeneratedValue.getId());
		return response;

	}

	public Product getProductByName(String productName) {

		return productRepo.findProductByName(productName);
	}

	public Product getProductById(Integer id) {
		return productRepo.findById(id).orElse(null);
	}

	public ProductResponse removeProduct(String productName) {
		ProductResponse response = new ProductResponse();
		Product product = productRepo.findProductByName(productName);

		if (product == null) {
			response.setResponseCode("0911");
			response.setResponseMessage("Product Not Found");
		} else {
			productRepo.delete(product);
			response.setResponseCode("0000");
			response.setResponseMessage("Product deleted successfully");
		}
		return response;
	}

	// display all
	public List<Product> displayAllProduct() {
		return productRepo.findAll();
	}
}
