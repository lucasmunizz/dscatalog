package com.dscatalog.demo.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.dscatalog.demo.entities.Product;

@SpringBootTest
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repository;
	
	@Test
	private void shouldDeleteObjectWhenDeleteById() {
		Long existingId = 1L;
		
		repository.deleteById(existingId);
		
		Optional<Product> product = repository.findById(existingId);
		
		Assertions.assertFalse(product.isPresent());
	}
	
	@Test
	private void shouldThrowEmptyDataAccessException() {
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			Long nonExistingId = 1000L;
			repository.deleteById(nonExistingId);
		});
	}
	
}
