package io.vladimirdev.firstmodule.controllers;

import io.vladimirdev.firstmodule.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
@RequiredArgsConstructor
public class WebControllers {
    private final ProductService productService;
    @GetMapping("/")
    String getGreeting(){
        return "index.html";
    }
    @GetMapping("/market")
    String getMarket(){
        return "market.html";
    }
}

