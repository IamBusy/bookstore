package com.william.controller;

import com.william.mapper.UserMapper;
import com.william.model.User;
import com.william.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by william on 17/3/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/",method = RequestMethod.GET)
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

}
