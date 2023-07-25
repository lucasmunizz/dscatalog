package com.dscatalog.demo.services;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dscatalog.demo.dto.ProductDTO;
import com.dscatalog.demo.entities.Product;
import com.dscatalog.demo.repositories.ProductRepository;
import com.dscatalog.demo.services.exceptions.DatabaseException;
import com.dscatalog.demo.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(PageRequest pageRequest){
		Page<Product> list = repository.findAll(pageRequest);
		return list.map(x -> new ProductDTO(x));		
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id){
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ProductDTO(entity, entity.getCategories());
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new ProductDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found");
		}
		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("data violated");
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not fonud");
		}
	}
}
