package com.william.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by william on 17/2/28.
 */

@Controller
public class AuthController
{

    @RequestMapping("/signin")
    public String signin()
    {
        return "login";
    }

}
