package com.example.cap19.controller;

import com.example.cap19.model.entity.Product;
import com.example.cap19.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping
  public Iterable<Product> index() {
    return productRepository.findAll();
  }

  @GetMapping("/name/{name}")
  public Iterable<Product> indexWithFilterByName(@PathVariable String name) {
    return productRepository.findByNameContainingIgnoreCase(name);
  }

  @GetMapping("/page/{numPage}/qtd/{qtdItems}")
  public Iterable<Product> indexWithPagination(@PathVariable int numPage, @PathVariable int qtdItems) {
    if (qtdItems >= 10) {
      qtdItems = 10;
    }
    Pageable pageable = PageRequest.of(numPage, qtdItems);
    return productRepository.findAll(pageable);
  }

  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
  public @ResponseBody Product store(@Valid Product product) {
    productRepository.save(product);
    return product;
  }

  @GetMapping("/{id}")
  public Optional<Product> show(@PathVariable int id) {
    return productRepository.findById(id);
  }

  @PutMapping("/{id}")
  public @ResponseBody Product update(@Valid Product product) {
    productRepository.save(product);
    return product;
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    productRepository.deleteById(id);
  }
}
