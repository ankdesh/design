package com.glarimy.catalog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.glarimy.catalog.domain.ProductRepository;
import com.glarimy.catalog.dto.Product;

@RestController
public class CatalogController {
	@Autowired
	private ProductRepository repo;

	public ResponseEntity<Product> add(Product product) {

	}

}
