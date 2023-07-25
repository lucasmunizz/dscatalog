package com.dscatalog.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dscatalog.demo.entities.Category;
import com.dscatalog.demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
