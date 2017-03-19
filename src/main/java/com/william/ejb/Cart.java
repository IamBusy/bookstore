package com.william.ejb;

import com.william.model.Product;
import com.william.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by william on 17/3/17.
 */
public class Cart {

    protected User user;
    protected HashMap<Integer,Integer> products = new HashMap<>();
    protected HashMap<Integer,Product> productsInfo = new HashMap<>();
    //protected List<Product> products;



    public HashMap<Product,Integer> get()
    {
        HashMap<Product,Integer> result = new HashMap<>();
        products.forEach((id,quantity)->{
            result.put(productsInfo.get(id),products.get(id));
        });
        return result;
    }

    public BigDecimal getPrice()
    {
        HashMap<Product,Integer> products = get();
        BigDecimal total = new BigDecimal(0);

        Iterator iterator =  products.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Product,Integer> entry = (Map.Entry)iterator.next();
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            total.add(product.getPrice().multiply(new BigDecimal(quantity)));
        }

        return total;
    }

    public void add(Product product,Integer quantity)
    {
//        Integer total = 0;
//        Iterator iterator = products.entrySet().iterator();
//        while (iterator.hasNext())
//        {
//            Map.Entry<Product,Integer> entry = (Map.Entry) iterator.next();
//            if(entry.getKey().getId()==product.getId())
//            {
//                total=entry.getValue();
//                break;;
//            }
//        }
        Integer total = 0;
        if(products.containsKey(product.getId()))
        {
            total = products.get(product.getId());
        }
        total+=quantity;

        products.put(product.getId(),total);
        productsInfo.put(product.getId(),product);
    }

    public void remove(Product product)
    {
        products.remove(product.getId());
        productsInfo.remove(product.getId());
    }

    public void destroy()
    {
        products = new HashMap<>();
        productsInfo = new HashMap<>();
    }

}
