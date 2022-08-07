package com.CartLifeCycle.Cart.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Cart")
@ToString
public class Cart
{
    @Id
    private int cartId;
    private Product product;
    private int Quantity;

}

