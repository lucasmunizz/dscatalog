package com.dscatalog.demo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {
	
	@Test
	private void test() {
		Assertions.assertTrue((0 + 1) == 1);
	}
}
