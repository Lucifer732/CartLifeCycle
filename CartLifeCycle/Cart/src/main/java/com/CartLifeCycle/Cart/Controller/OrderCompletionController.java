package com.CartLifeCycle.Cart.Controller;

import com.CartLifeCycle.Cart.Entity.OrderCompletion;
import com.CartLifeCycle.Cart.Services.OrderCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordersPlaced")
public class OrderCompletionController {

    @Autowired
    private OrderCompletionService orderCompletionService;

    @PostMapping("/validateAndPlaceOrder/{oid}")
    public void validateAndPlaceOrder(@PathVariable int oid){
        orderCompletionService.validateAndPlaceOrder(oid);
    }

    @GetMapping("/getAllPlacedOrders")
    public List<OrderCompletion> getAllPlacedOrders(){
        return orderCompletionService.getAllPlacedOrders();
    }

}
