package io.vladimirdev.catalogueservice.controllers;

import io.vladimirdev.catalogueservice.repositories.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final CustomerRepo customerRepo;
@GetMapping
String index() {
    return "some text "+ new Date()+", "+customerRepo.findAll();
}
}
