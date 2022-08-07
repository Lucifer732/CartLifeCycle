package com.CartLifeCycle.Cart.Services;

import com.CartLifeCycle.Cart.Entity.Cart;
import com.CartLifeCycle.Cart.Entity.DeliveryDetails;
import com.CartLifeCycle.Cart.Entity.OrderCompletion;
import com.CartLifeCycle.Cart.Repository.DeliveryRepository;
import com.CartLifeCycle.Cart.Repository.OrderCompletionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderCompletionService {
    @Autowired
    private OrderCompletionRepository orderCompletionRepository;
    @Autowired
    private RestTemplate restTemplate;
    int poId=0;
    public void validateAndPlaceOrder(int oid) {
        DeliveryDetails deliveryDetails=restTemplate.getForObject("http://localhost:8081/delivery/getDeliveryDetailsById/"+ oid ,DeliveryDetails.class);
        if(deliveryDetails.getPayment().equals("COD")  && !(deliveryDetails.getAddress().isBlank())){
            OrderCompletion orderCompletion = new OrderCompletion();
            orderCompletion.setPlacedId(++poId);
            orderCompletion.setDeliveryDetails(deliveryDetails);
            orderCompletionRepository.save(orderCompletion);
        }
    }

    public List<OrderCompletion> getAllPlacedOrders() {
        return orderCompletionRepository.findAll();
    }
}