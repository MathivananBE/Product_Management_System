package edu.jsp.Product_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Product_app.Service.ProductService;
import edu.jsp.Product_app.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product p) {

		return new ResponseEntity<Product>(service.saveProduct(p), HttpStatus.CREATED);
	}

	@GetMapping("/fetchById")
	public ResponseEntity<Product> fetchById(@RequestParam int id) {
		return new ResponseEntity<Product>(service.fetchById(id), HttpStatus.OK);
	}

	@GetMapping("/fetchAll")
	public List<Product> fetchAll() {

		return service.fetchAll();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable int id) {

		Product p = service.fetchById(id);

		if (p != null) {
			return new ResponseEntity<String>(service.DeleteById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Id not Found", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("UpdatePriceAndQuantity")
	public String UpdatePriceAndQuantity(@RequestParam int id, @RequestParam double price, @RequestParam int quantity) {

		return service.updatePriceAndQuantity(id, price, quantity);
	}

	@PutMapping("update")
	public Product update(@RequestParam int id, @RequestBody Product newProduct) {

		return service.update(id, newProduct);

	}

	@GetMapping("fetchByBrand/{brand}")
	public ResponseEntity<?> fetchByBrand(@PathVariable String brand) {
		Product p = service.fetchByBrand(brand);
		if (p != null) {
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Brand not found", HttpStatus.NOT_FOUND);
	}

}
