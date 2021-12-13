package com.vyatsu.task14.repositories;

import com.vyatsu.task14.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;
    private List<Product> filterProducts;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Bread", 40));
        products.add(new Product(2L, "Milk", 90));
        products.add(new Product(3L, "Cheese", 200));
        filterProducts = products;
    }

    public List<Product> findAll() {
        filterProducts = products;
        return filterProducts;
    }

    public Product findByTitle(String title) {
        return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void save(Product product) {
        products.add(product);
        filterProducts = products;
    }

    public void delete(Product product){
        products.removeIf(p -> p.getId() == product.getId());
        filterProducts = products;
    }

    public void update(Product product){
        Product updateProduct = findById(product.getId());
        updateProduct.setTitle(product.getTitle());
        updateProduct.setPrice(product.getPrice());
        filterProducts = products;
    }


    public void findFilter1(String str){
        filterProducts = products;
        for(int i = filterProducts.size()-1; i>=0; i--){
            if(!filterProducts.get(i).getTitle().contains(str)){
                filterProducts.remove(filterProducts.get(i));
            }
        }
    }

    public void findFilter2(String title, int minPrice, int maxPrice){
        findFilter1(title);
        for(int i = filterProducts.size()-1; i>=0; i--){
            if(filterProducts.get(i).getPrice() < minPrice & filterProducts.get(i).getPrice() > minPrice){
                filterProducts.remove(filterProducts.get(i));
            }
        }

    }

}
