package com.CartLifeCycle.Cart.Services;

import com.CartLifeCycle.Cart.Entity.Cart;
import com.CartLifeCycle.Cart.Entity.Product;
import com.CartLifeCycle.Cart.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CartService
{
    @Autowired
    CartRepository cartRepository;
    Cart cart =new Cart();
    @Autowired
    RestTemplate restTemplate;
    int cNum=0;
    public void addToCart(int pid)
    {
        Product product=restTemplate.getForObject("http://localhost:8080/Product/"+ pid ,Product.class);
        cart.setCartId(++cNum);
        cart.setProduct(product);
        cart.setQuantity(1);
        cartRepository.save(cart);
    }
    public void updateQuantity(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getAllCartProducts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getProductInCartById(int cid) {
        return cartRepository.findById(cid);
    }

    public void deleteProductInCart(int cid) {
        cartRepository.deleteById(cid);
    }
}
