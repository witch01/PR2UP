package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.models.Product;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/prod")
    public String blogMain(Model model)
    {
        Iterable<Product> product = productRepository.findAll();
        model.addAttribute("product", product);
        return "product-main";
    }

    @GetMapping("/product/add")
    public String ProductAdd(Model model)
    {
        return "product-add";
    }

    @PostMapping("/product/add")
    public String ProductPostAdd(@RequestParam(defaultValue = "0") String names,
                                  @RequestParam(defaultValue = "0") double cent,
                                  @RequestParam(defaultValue = "false") boolean online,
                                  @RequestParam(defaultValue = "0") int quantity,
                                  @RequestParam(defaultValue = "0000.00.00") Date dr, Model model)
    {

        Product product = new Product(names, dr, online, cent, quantity);
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/filter")
    public String productFilter(Model model)
    {
        return "product-filter";
    }

    @PostMapping("/product/filter/result")
    public String productResult(@RequestParam String names, Model model)
    {
        List<Product> result = productRepository.findByNamesContains(names);
        List<Product> result1 = productRepository.findByNames(names);
//        List<Post> result = postRepository.findLikeTitle(title);
        model.addAttribute("result", result);
        return "product-filter";
    }
}

