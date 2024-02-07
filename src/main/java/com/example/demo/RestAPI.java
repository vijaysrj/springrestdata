package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {

	@Autowired
	private ProductRepository repository;

	@GetMapping("/product")
	public Iterable<Product> getAllProducts() {

		return this.repository.findAll();
	}

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {

		return this.repository.findById(id).get();
	}
	@GetMapping("/product/name/{name}")
	public List<Product> getProductByName(@PathVariable String name) {

		return this.repository.findByName(name);
	}

	@GetMapping("/api/product")
	public Product getProductById(@RequestParam("id") int id) {

		return this.repository.findById(id).get();
	}

	@PostMapping(path = "/product")
	public void addProduct(@RequestBody Product product) {

		this.repository.save(product);

	}

	@PutMapping("/product")
	public void updateProduct(@RequestBody Product product) {

		this.repository.save(product);

	}

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable int id) {

		this.repository.deleteById(id);
	}

}
