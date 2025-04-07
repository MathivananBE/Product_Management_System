package edu.jsp.Product_app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Product_app.Repository.ProductRepository;
import edu.jsp.Product_app.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public Product saveProduct(Product p) {

		return repo.save(p);
	}

	public Product fetchById(int id) {
		Optional<Product> o = repo.findById(id);
		if (o.isPresent()) {
			return o.get();
		}
		return null;
	}

	public List<Product> fetchAll() {

		return repo.findAll();
	}

	public String DeleteById(int id) {
		Product p = fetchById(id);

		if (p != null) {
			repo.deleteById(id);

			return "data deleted...";
		}
		return "data not found";
	}

	public String updatePriceAndQuantity(int id, double price, int quantity) {
		Product p = fetchById(id);
		if (p != null) {

			p.setPrice(price);
			p.setQuantity(quantity);

			repo.save(p);
			return "Data Updated...";

		}
		return "Id not Found";
	}

	public Product update(int id, Product newProduct) {
		Product existingProduct = fetchById(id);

		if (existingProduct != null) {
			newProduct.setId(id);

			return repo.save(newProduct);
		}
		return null;
	}

	public Product fetchByBrand(String brand) {
		return repo.findByBrand(brand);
	}
}
