package com.CartLifeCycle.Cart.Repository;

import com.CartLifeCycle.Cart.Entity.OrderCompletion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCompletionRepository extends MongoRepository<OrderCompletion,Integer> {
}
