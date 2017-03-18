package com.william.controller;

import com.william.mapper.ProductMapper;
import com.william.model.Product;
import com.william.model.ProductExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.List;

/**
 * Created by william on 17/2/28.
 */
@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {

    @Autowired
    private ProductMapper productMapper;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Product> get()
    {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andIdBetween(2000,2100);
        return this.productMapper.selectByExample(productExample);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Integer id)
    {
        Product product = productMapper.selectByPrimaryKey(id);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product info(@PathVariable long id, ProductExample productExample) throws AuthenticationException
    {
        try{
            productExample.createCriteria().andIdEqualTo((int)id);
            return this.productMapper.selectByExample(productExample).get(0);
        }
        catch (IndexOutOfBoundsException e)
        {
            return null;
        }

    }

}
