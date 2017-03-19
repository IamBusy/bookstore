package com.william.repository;

import com.william.mapper.OrderMapper;
import com.william.mapper.OrderProductMapper;
import com.william.mapper.ProductMapper;
import com.william.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by william on 17/3/19.
 */
@Repository("orderRepository")
public class OrderRepository {

    @Autowired
    private OrderProductMapper orderProductMapper;
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    public List<Product> getProducts(Order order, OrderProductExample orderProductExample, ProductExample productExample)
    {
        List<Product> products = new ArrayList<>();
        orderProductExample.clear();
        orderProductExample.createCriteria().andOrderIdEqualTo(order.getId());
        List<OrderProduct> orderProducts = orderProductMapper.selectByExample(orderProductExample);

        for (OrderProduct orderProduct:orderProducts)
        {
            Product product = productMapper.selectByPrimaryKey(orderProduct.getProductId());
            product.setQuantity(orderProduct.getQuantity());
            products.add(product);
        }
        return products;
    }

    public boolean create(User user, HashMap<Product,Integer> products,BigDecimal amount) throws Exception
    {
        if(products.size()==0)
        {
            throw  new Exception("Cart is empty");
        }

        Date curTime = new Date();
        Date createdAt = new Date(curTime.getYear(),curTime.getMonth(),curTime.getDay(),
                curTime.getHours(),curTime.getMinutes(),curTime.getSeconds());

        OrderWithBLOBs order =  getAssembledOrder(createdAt);
        order.setUserId(user.getId());
        order.setTotal(amount);
        order.setUserName(user.getUserName());
        order.setPhone(user.getPhone());




        //Integer orderId2 = orderMapper.insertSelective(order);
        orderMapper.insert(order);
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andCreatedAtEqualTo(createdAt);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        Order order1 =  orders.get(0);
        System.out.print(order1.getId());
        products.forEach((product,quantity)->{
            Short isnew = 1;
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setQuantity(quantity);
            orderProduct.setIsnew(isnew);
            orderProduct.setWarehouseId(1);

            orderProduct.setOrderId(order1.getId());
            orderProduct.setPrice(product.getPrice());
            orderProduct.setProductId(product.getId());
            orderProductMapper.insert(orderProduct);
        });

        return  true;

    }

    private OrderWithBLOBs getAssembledOrder(Date createdAt)
    {
        Short mode = 1;
        BigDecimal zeroDecimal = new BigDecimal(0);
        OrderWithBLOBs order = new OrderWithBLOBs();
        order.setPaymentName("");
        order.setStoreName("");
        order.setMode(mode);
        order.setDiscount(zeroDecimal);
        order.setActualPayAmount(zeroDecimal);
        order.setForegift(zeroDecimal);
        order.setStoreId(1);
        order.setOrderStatusId(1);
        order.setPaymentId(1);
        order.setPayAmount(zeroDecimal);
        order.setActualPayForegift(zeroDecimal);
        order.setShippingId(1);
        order.setShippingName("");
        order.setSchoolId(1);
        order.setSchoolName("");
        order.setProvince(797);
        order.setProvinceName("");
        order.setCity(797);
        order.setCityName("");
        order.setDistrict(797);
        order.setDistrictName("");
        order.setAddress("");
        order.setCustomField("");
        order.setPostcode("");
        order.setIp("");
        order.setIspaid(new Byte("1"));
        order.setShippingAmount(zeroDecimal);
        order.setExpressNumber("");
        order.setRemark("");
        order.setCreatedAt(createdAt);
        return order;
    }
}
