package com.Ftd.Product.Validator;

import com.Ftd.Product.Entity.Product;
import com.Ftd.Product.Exceptions.InputInvalidationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductValidator {
    public void Validator(Product product) throws InputInvalidationException {
        if(Objects.isNull(product))
        {
            throw new InputInvalidationException(HttpStatus.BAD_REQUEST.value(),"Invalid Input");
        } else if (product.getId()<=0) {
            throw new InputInvalidationException(HttpStatus.BAD_REQUEST.value(),"Invalid Input");

        }
    }
}
