package com.vyatsu.task14.controllers;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8189/demo

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showProductsList(Model model) {
        Product product = new Product();
        model.addAttribute("products", productsService.getAllProducts());
        model.addAttribute("product", product);
        return "products";
    }

    @PostMapping("/filter1")
    public String filter1(@ModelAttribute(value="title") String title, Model model){
        productsService.setFilter1(title);
        return "redirect:/products";
    }

    @PostMapping("/filter2")
    public String filter2(@ModelAttribute(value="minPrice") int minPrice,
                          @ModelAttribute(value="maxPrice") int maxPrice,
                          @ModelAttribute(value="title") String title,
                          Model model){
        productsService.setFilter2(title, minPrice, maxPrice);
        return "redirect:/products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product")Product product) {
        productsService.add(product);
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute(value="id")Long id){
        productsService.delete(id);
        return  "redirect:/products";
    }

    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
        Product product = productsService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product){
        productsService.update(product);
        return "redirect:/products";
    }


}
