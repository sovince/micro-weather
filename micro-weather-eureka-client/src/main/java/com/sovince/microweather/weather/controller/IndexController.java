package com.sovince.microweather.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/7/9
 * Time: 19:37
 * Description:
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "Hello Spring Cloud!";
    }
}
