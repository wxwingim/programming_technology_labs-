package com.vyatsu.task14.services.impl;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.repositories.ProductRepos;
import com.vyatsu.task14.services.ProductServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import javax.persistence.EntityNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.vyatsu.task14.Specs.ProductSpecs.*;

@Service
public class ProductServiceImpl implements ProductServ {
    @Autowired
    private ProductRepos productRepos;

    @Override
    public Product addProduct(Product product){
        Product savedProduct = productRepos.saveAndFlush(product);
        return savedProduct;
    }

    @Override
    public void delete(Long id) {
        productRepos.deleteById(id);
    }

    @Override
    public Product getById(Long id){
        return productRepos.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Product getByName(String title) {
        return productRepos.findByName(title);
    }

    @Override
    public void editProduct(Product product) {
        productRepos.saveAndFlush(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepos.findAll();
    }

    @Override
    public Page<Product> findPage(Pageable pageable){
        return productRepos.findAll(pageable);
    }

    @Override
    public List<Product> filter1(String title){
        return productRepos.findAll(titleContainsWord(title));
    }

    @Override
    public List<Product> filter2(BigDecimal maxPrice, BigDecimal minPrice){
        List<Product> list1 = productRepos.findAll(priceGreaterThanOrEq(minPrice));
        List<Product> list2 = productRepos.findAll(priceLesserThanOrEq(maxPrice));
        List<Product> list = new ArrayList<>();
        for(Product product: list1){
            if(list2.contains(product)){
                list.add(product);
            }
        }
        return list;
    }

}
