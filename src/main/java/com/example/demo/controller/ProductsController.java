package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.ProductsEntity;
import com.example.demo.service.ProductsService;


@RestController
public class ProductsController {
	
	@Autowired
	private ProductsEntity productEntity;
	
	@Autowired
	private ProductsService productService;
	
	
	@GetMapping("/products")
	public ModelAndView getProducts(ModelAndView model) {
		
		List<ProductsEntity> list = new ArrayList();
		
		list = productService.findAllProducts();
		
		
		model.setViewName("products");
		return model;
	}

}
