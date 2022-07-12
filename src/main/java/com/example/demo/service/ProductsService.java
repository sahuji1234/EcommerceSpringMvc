package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductsEntity;
import com.example.demo.repository.ProductsRepo;


@Service
public class ProductsService {

	@Autowired
	private ProductsRepo productsRepo;
	
	
	public List<ProductsEntity> findAllProducts() {
		List<ProductsEntity> list = new ArrayList();
		list = productsRepo.findAll();
		return list;
	}

}
