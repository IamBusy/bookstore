package com.william.controller;

import com.william.ejb.Cart;
import com.william.mapper.OrderMapper;
import com.william.mapper.OrderProductMapper;
import com.william.mapper.ProductMapper;
import com.william.mapper.UserMapper;
import com.william.model.*;
import com.william.repository.OrderRepository;
import com.william.repository.UserRepository;
import com.william.utils.Des;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by william on 17/3/18.
 */
@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private Cart cart;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderRepository orderRepository;




    @RequestMapping(value = "",method = RequestMethod.POST)
    public void create(HttpServletRequest request,
                       @RequestParam String  pwd,
                       UserExample userExample) throws JSONException,Exception
    {
        if(pwd.length()==0)
        {
            throw new Exception("Invalid password");
        }

        Des decoder = new Des();
        HashMap<Product,Integer> products = cart.get();
        Double keyNum = (Double) request.getSession().getAttribute("orderKey");
        String key = keyNum.toString();
        String originalPwd = decoder.strDec(pwd,key,null,null);
        System.out.print(originalPwd);
        userExample.createCriteria().andPhoneEqualTo(request.getUserPrincipal().getName());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()==0)
        {
            throw new Exception("Invalid user");
        }
        if(!users.get(0).getPassword().equals(originalPwd))
        {
            throw new Exception("Invalid user");
        }

        orderRepository.create(users.get(0),cart.get(),cart.getPrice());
        cart.destroy();

    }



    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Order> get(OrderExample orderExample, HttpServletRequest httpServletRequest)
    {
        return orderMapper.selectByExample(orderExample);
    }





}
