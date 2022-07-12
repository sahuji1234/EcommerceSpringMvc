package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductsEntity;

@Repository
public interface ProductsRepo extends JpaRepository<ProductsEntity,Long> {

}
