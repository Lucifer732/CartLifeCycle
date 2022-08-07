package com.Ftd.Product.Controller;

import com.Ftd.Product.Entity.Product;
import com.Ftd.Product.Exceptions.InputInvalidationException;
import com.Ftd.Product.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Product")
public class ProductController
{
    @Autowired
    ProductService productService;

    @PostMapping("/")
    public void addProduct(@RequestBody Product products) throws InputInvalidationException {
        productService.addProduct(products);
    }
    @PutMapping
    public void updateProduct(@RequestBody Product products)
    {
        productService.updateProduct(products);
    }
    @GetMapping
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id)
    {
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public void delProductById(@PathVariable int id)
    {
        productService.delProductById(id);
    }

}
