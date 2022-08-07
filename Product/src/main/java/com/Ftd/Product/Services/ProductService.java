package com.Ftd.Product.Services;

import com.Ftd.Product.Entity.Product;
import com.Ftd.Product.Exceptions.InputInvalidationException;
import com.Ftd.Product.Repository.ProductRepository;
import com.Ftd.Product.Validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class ProductService
{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductValidator productValidator;
    public void addProduct(Product products) throws InputInvalidationException {
        productValidator.Validator(products);
        if(Objects.isNull(productRepository.findById(products.getId()))) {
            productRepository.save(products);
        }
        else
        {
            throw new InputInvalidationException(HttpStatus.BAD_REQUEST.value(),"Product ID Repeated");
        }
    }

    public void updateProduct(Product products)
    {
        productRepository.save(products);
    }

    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    public void delProductById(int id)
    {
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(int id)
    {
        return productRepository.findById(id);
    }
}
