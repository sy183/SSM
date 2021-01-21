package com.suy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/") //请求路径
    public String index() {
        return "index"; //返回指定的页面，会自定添加前缀和后缀找到对应的文件
    }
}
