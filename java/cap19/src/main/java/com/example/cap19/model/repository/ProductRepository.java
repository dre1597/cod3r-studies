package com.example.cap19.model.repository;

import com.example.cap19.model.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
  public Iterable<Product> findByNameContainingIgnoreCase(String name);
}
