package com.example.SimpleProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TempController {
    @RequestMapping("/temp")
    @ResponseBody
    public String temp() {
        return "temp";
    }
    @RequestMapping("/about")
    @ResponseBody
    public String about() {
        return "About us";
    }
}
