package com.vyatsu.task14.controllers;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;


// http://localhost:8189/demo/

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductServiceImpl productServiceImpl;

    @Autowired
    public void setProductServiceImpl(ProductServiceImpl productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }



    @GetMapping
    public String showProducts(Model model){
        Product product = new Product();
        model.addAttribute("products", productServiceImpl.getAll());
        model.addAttribute("product", product);
        return "products";
    }

    // Page
    @GetMapping("/prview")
    public String listProducts(Model model,
                               @PageableDefault(size=5) Pageable pageable
                               ){
        Page<Product> pageProducts = productServiceImpl.findPage(pageable);
        model.addAttribute("products", pageProducts.getContent());
        model.addAttribute("page", pageProducts);

        return "/proddetail";
    }

    @PostMapping("/filter1")
    public String filter1(@ModelAttribute(value="title") String title, Model model){
        Product product = new Product();
        List<Product> products = productServiceImpl.filter1(title);
        model.addAttribute("products", products);
        model.addAttribute("product", product);
        return ("/f1");
    }

    @PostMapping("/filter2")
    public String filter2(@ModelAttribute(value="minPrice") BigDecimal minPrice,
                          @ModelAttribute(value="maxPrice") BigDecimal maxPrice,
                          Model model){
        Product product = new Product();
        List<Product> products = productServiceImpl.filter2(maxPrice, minPrice);
        model.addAttribute("products", products);
        model.addAttribute("product", product);
        return ("/f1");
    }

    @PostMapping("/showUpdate")
    public String showUpdate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/update-product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product")Product product,
                             Model model){
//        model.addAttribute("product", product);
        productServiceImpl.addProduct(product);
        return "redirect:/products";
    }
//
    @PostMapping("/delete")
    public String delete(@ModelAttribute(value="id")Long id){
        productServiceImpl.delete(id);
        return  "redirect:/products";
    }

    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
        Product product = productServiceImpl.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }

    @PostMapping("/update")
    public String update (@ModelAttribute("product") Product product){
        productServiceImpl.editProduct(product);
        return "redirect:/products";
    }

//    @PostMapping("/authenticateTheUser")
//    public String getPrincipal() {
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails) principal).getUsername();
//        } else {
//            userName = principal.toString();
//        }
//        return userName;
//    }
}
