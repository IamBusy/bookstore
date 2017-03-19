package com.william.controller;

import com.william.mapper.OrderMapper;
import com.william.mapper.UserMapper;
import com.william.model.*;
import com.william.repository.OrderRepository;
import com.william.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by william on 17/3/17.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> get(UserExample userExample)
    {
        return userMapper.selectByExample(userExample);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User info(@PathVariable Integer id, HttpServletRequest request)
    {
        System.out.print(request.getUserPrincipal().getName());
        return userMapper.selectByPrimaryKey(id);
    }



    @RequestMapping("/{id}/orders")
    public List<Order> getByUser(@PathVariable Integer id, OrderExample orderExample,
                                 OrderProductExample orderProductExample,
                                 ProductExample productExample)
    {
        orderExample.createCriteria().andUserIdEqualTo(id);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        Iterator iterator = orders.iterator();
        while (iterator.hasNext())
        {
            Order order = (Order) iterator.next();
            order.setProducts(orderRepository.getProducts(order,orderProductExample,productExample));
        }
        return orders;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public User show(HttpServletRequest request)
    {
        return this.userRepository.selectByPhone(request.getUserPrincipal().getName());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void destroy(@PathVariable Integer id)
    {
        userMapper.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public User create(@RequestParam String account,
                       @RequestParam String pwd,
                       @RequestParam String name) throws Exception
    {

        if(userRepository.selectByPhone(account)!=null)
        {
            throw  new  Exception("Duplicate user");
        }

        User user = userRepository.create(account,pwd,name);
        return  user;

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User update(@PathVariable Integer id,
                       @RequestBody User user) throws Exception
    {
        System.out.print(user);

        String account = "";

        //User user = userMapper.selectByPrimaryKey(id);
        User existUser = userRepository.selectByPhone(account);
        if(existUser!=null && existUser.getId().equals(user.getId()))
        {
            throw  new  Exception("Duplicate user");
        }

        //user.setPassword(pwd);
        //user.setUserName(name);
        user.setPhone(account);

        userMapper.updateByPrimaryKey(user);
        return user;
    }


}
