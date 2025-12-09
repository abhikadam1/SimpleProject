package com.example.SimpleProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;
import java.util.Optional;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
