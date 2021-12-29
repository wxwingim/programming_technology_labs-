package com.vyatsu.task14.services;

import com.vyatsu.task14.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductServ {
    Product addProduct(Product product);
    void delete(Long id);
    Product getById(Long id);
    Product getByName(String title);
    void editProduct(Product product);
    List<Product> getAll();
    List<Product> filter1(String title);
    List<Product> filter2(BigDecimal maxPrice, BigDecimal minPrice);


    Page<Product> findPage(Pageable pageable);

}
