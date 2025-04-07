package edu.jsp.Product_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.Product_app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	// save (Product t) update----> save
	// findById(Integer i)
	// findAll()
	// deleteById(Integer i)

	Product findByBrand(String brand);

}
