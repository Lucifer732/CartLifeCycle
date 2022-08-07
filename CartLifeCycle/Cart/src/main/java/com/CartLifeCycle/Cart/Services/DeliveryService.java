package com.CartLifeCycle.Cart.Services;

import com.CartLifeCycle.Cart.Entity.Cart;
import com.CartLifeCycle.Cart.Entity.DeliveryDetails;
import com.CartLifeCycle.Cart.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private RestTemplate restTemplate;


    int ordNo=0;
    public void addDeliveryDetails(DeliveryDetails deliveryDetails,int cid) {
        Cart cart=restTemplate.getForObject("http://localhost:8081/getProductInCartById/"+ cid ,Cart.class);
        deliveryDetails.setOrderId(++ordNo);
        deliveryDetails.setCart(cart);
        deliveryRepository.save(deliveryDetails);

    }

    public Optional<DeliveryDetails> getDeliveryDetailsById(int id) {
        return deliveryRepository.findById(id);
    }
}
