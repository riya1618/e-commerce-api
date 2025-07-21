package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.entity.Product;
import org.dnyanyog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	Product prodcut;

	@Autowired
	ProductService productService;

	@PostMapping(path = "/addProduct", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ProductResponse saveProduct(@RequestBody ProductRequest request) {
		return productService.addProduct(request);
	}

	// search by name
	@GetMapping(path = "/productname", produces = { "application/json", "application/xml" })
	public Product getProductByName(@PathVariable String productName) {
		return productService.getProductByName(productName);

	}

	// search by id
	@GetMapping(path = "/{id}")
	public Product getProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}

	// Delete
	@DeleteMapping(path = "{name}")
	public ProductResponse removeUser(@PathVariable String productName) {
		return productService.removeProduct(productName);
	}

	@GetMapping(path = "/AllProduct")
	public List<Product> displayAllProduct() {
		return productService.displayAllProduct();
	}

}
