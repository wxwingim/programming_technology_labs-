package com.vyatsu.task14.services;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setFilter1(String str){
        productRepository.findFilter1(str);
    }
    public void setFilter2(String title, int minPrice, int maxPrice){
        productRepository.findFilter2(title, minPrice, maxPrice);
    }

    public Product getById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//    public void getAllProductsFilter1(String str){
//        productRepository.findFilter1(str);
//    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public void delete(long id){
        productRepository.delete(productRepository.findById(id));
    }

    public void update(Product product){
        productRepository.update(product);
    }
}
