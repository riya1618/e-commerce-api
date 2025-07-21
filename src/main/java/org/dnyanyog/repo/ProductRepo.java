package org.dnyanyog.repo;

import org.dnyanyog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

	
	Product findProductByName(String name);
}