package io.vladimirdev.catalogueservice.controllers;

import io.vladimirdev.catalogueservice.entities.Player;
import io.vladimirdev.catalogueservice.repositories.CustomerRepo;
import io.vladimirdev.catalogueservice.repositories.PlayersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final CustomerRepo customerRepo;
    private final PlayersRepo playersRepo;
@GetMapping
String index() {
    return   "some text "+ new Date()+", "+customerRepo.findAll();
}

    @GetMapping("/p")
    List<Player> getAllPlayers(){
        return playersRepo.findAll();
    }
}

