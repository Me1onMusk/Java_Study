package com.helloshop.order;

import com.helloshop.product.Product;
import com.helloshop.user.User;

public class Order {
    User user;
    Product product;

    // 생성자 //
    public Order(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
