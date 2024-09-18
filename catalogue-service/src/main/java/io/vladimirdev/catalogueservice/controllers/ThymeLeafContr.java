package io.vladimirdev.catalogueservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeLeafContr {
@GetMapping("c-p")
    public String changePass() {
    return "changepass";
}
}
