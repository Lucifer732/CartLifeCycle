package com.Ftd.Product.Repository;


import com.Ftd.Product.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,Integer>
{

}
