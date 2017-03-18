package com.william.controller;

import com.william.mapper.OrderMapper;
import com.william.model.Order;
import com.william.model.OrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by william on 17/3/18.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;


    @RequestMapping("/")
    public List<Order> get(OrderExample orderExample, HttpServletRequest httpServletRequest)
    {
        httpServletRequest.getUserPrincipal();
        return orderMapper.selectByExample(orderExample);
    }

}
