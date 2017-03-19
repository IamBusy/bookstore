package com.william.controller;

import com.william.mapper.CategoryMapper;
import com.william.mapper.ProductMapper;
import com.william.model.Category;
import com.william.model.CategoryExample;
import com.william.model.Product;
import com.william.model.ProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by william on 17/3/18.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Category> get(CategoryExample categoryExample)
    {
        return categoryMapper.selectByExample(categoryExample);
    }


    @RequestMapping("/{id}/products")
    public List<Product> products(@PathVariable Integer id, ProductExample productExample)
    {
        productExample.createCriteria().andCategoryIdEqualTo(id);
        return productMapper.selectByExample(productExample);
    }
}
