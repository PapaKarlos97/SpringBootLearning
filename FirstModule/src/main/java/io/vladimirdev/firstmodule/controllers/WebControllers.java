package io.vladimirdev.firstmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class WebControllers {
    @GetMapping("/")
    String getGreeting(){
        return "index.html";
    }

}

