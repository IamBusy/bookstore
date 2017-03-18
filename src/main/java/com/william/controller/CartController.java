package com.william.controller;

import com.william.ejb.Cart;
import com.william.mapper.ProductMapper;
import com.william.model.Product;
import com.william.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by william on 17/3/17.
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("/")
    public HashMap<Product,Integer>get()
    {
        Cart cart;
        cart = SpringContextUtil.getBean("cart");
        cart.add(productMapper.selectByPrimaryKey(1000),100);
        return cart.get();
    }
}
