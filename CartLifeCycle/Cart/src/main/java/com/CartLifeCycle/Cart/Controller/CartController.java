package com.CartLifeCycle.Cart.Controller;

import com.CartLifeCycle.Cart.Entity.Cart;
import com.CartLifeCycle.Cart.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class CartController
{
    @Autowired
    CartService cartService;

    @PostMapping("/{pid}")
    public void addToCart(@PathVariable int pid)
    {
        cartService.addToCart(pid);
    }
    @PutMapping("/updateCart")
    public void updateQuantity(@RequestBody Cart cart) {
        cartService.updateQuantity(cart);
    }

    @GetMapping("/getAllCartProducts")
    public List<Cart> getAllCartProducts(){
        return cartService.getAllCartProducts();
    }
    @GetMapping("/getProductInCartById/{cid}")
    public Optional<Cart> getProductInCartById(@PathVariable int cid){
        return  cartService.getProductInCartById(cid);
    }
    @DeleteMapping("/{cid}")
    public void deleteProductInCart(@PathVariable int cid){
        cartService.deleteProductInCart(cid);
    }

}
