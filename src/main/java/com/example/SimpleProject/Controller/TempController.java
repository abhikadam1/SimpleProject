package com.example.SimpleProject.Controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class TempController {
    @RequestMapping("/temp")
    @ResponseBody
    public String temp() {
        return "temp";
    }

    public String temp111() {
        return "temp111";
    }
    @RequestMapping("/about")
    @ResponseBody
    public String about() {
        return "About us";
    }
}
