package com.william.controller;

import com.william.ejb.Cart;
import com.william.mapper.ProductMapper;
import com.william.model.Product;
import com.william.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by william on 17/3/17.
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private ProductMapper productMapper;

    private Cart cart;


    public CartController() {
        this.cart = (Cart) SpringContextUtil.getBean("cart");
    }




    @RequestMapping("")
    public List<Product>get()
    {
        List<Product> products=new ArrayList<>();
        cart.get().forEach((product,quantity)->{
            product.setQuantity(quantity);
            products.add(product);
        });
        return products;
    }

    @RequestMapping(value = "products/{id}",method = RequestMethod.POST)
    public void add(@PathVariable Integer id, @RequestParam Integer quantity)
    {
        Product product = productMapper.selectByPrimaryKey(id);
        cart.add(product,quantity);
    }

    @RequestMapping(value = "products/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Integer id,@RequestParam Integer quantity)
    {
        Product product = productMapper.selectByPrimaryKey(id);
        cart.remove(product);
        cart.add(product,quantity);
    }


    @RequestMapping(value = "products/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id)
    {
        Product product = productMapper.selectByPrimaryKey(id);
        cart.remove(product);
    }
}
