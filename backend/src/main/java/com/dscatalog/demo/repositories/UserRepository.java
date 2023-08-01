package com.dscatalog.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dscatalog.demo.entities.Category;
import com.dscatalog.demo.entities.Product;
import com.dscatalog.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
