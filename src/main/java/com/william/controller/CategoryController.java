package com.william.controller;

import com.william.mapper.CategoryMapper;
import com.william.model.Category;
import com.william.model.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by william on 17/3/18.
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Category> get(CategoryExample categoryExample)
    {
        return categoryMapper.selectByExample(categoryExample);
    }
}
