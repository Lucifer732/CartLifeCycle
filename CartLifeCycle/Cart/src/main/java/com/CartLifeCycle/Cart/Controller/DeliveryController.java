package com.CartLifeCycle.Cart.Controller;

import com.CartLifeCycle.Cart.Entity.DeliveryDetails;
import com.CartLifeCycle.Cart.Services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/addDelivery/{cid}")
    public void addDeliveryDetails(@RequestBody DeliveryDetails deliveryDetails,@PathVariable int cid){
        deliveryService.addDeliveryDetails(deliveryDetails,cid);
    }

    @GetMapping("/getDeliveryDetailsById/{id}")
    public Optional<DeliveryDetails> getDeliveryDetailsById(@PathVariable int id){
        return deliveryService.getDeliveryDetailsById(id);
    }
}
