package com.CartLifeCycle.Cart.Repository;


import com.CartLifeCycle.Cart.Entity.DeliveryDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepository extends MongoRepository<DeliveryDetails,Integer> {
}