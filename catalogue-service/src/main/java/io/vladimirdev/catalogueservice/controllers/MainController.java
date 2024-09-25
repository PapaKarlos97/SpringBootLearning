package io.vladimirdev.catalogueservice.controllers;

import io.vladimirdev.catalogueservice.entities.Player;
import io.vladimirdev.catalogueservice.repositories.CustomerRepo;
import io.vladimirdev.catalogueservice.repositories.PlayersRepo;
import io.vladimirdev.catalogueservice.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final CustomerRepo customerRepo;
    private final PlayersRepo playersRepo;
    private final PlayerService playerService;
@GetMapping
String index() {
    return   "some text "+ new Date()+", "+customerRepo.findAll();
}

    @GetMapping("/p")
    List<Player> getAllPlayers(){
        return playersRepo.findAll();
    }
    @PostMapping("/edit/{id}")
    String getNumber(@PathVariable int id){
    return "this number is: "+id;
    }
//    @PostMapping("/send")
//    void sendMoney(@AuthenticationPrincipal Player player,
//            @RequestParam ("id")int toId, @RequestParam("sum") int addSum){
//        int fromId = player.getId();
//        int fromSum=player.getBalance();
//
//        playerService.sendMoney(fromId,toId,addSum);
//
////        if (playersRepo.findById(toId).isPresent()){
////    Player playerRecipient = playersRepo.findById(toId).get();
////            return "From "+player.getName()+", to "+playerRecipient.getName()+", send "+addSum+"$";
////    }
////        return "Player not found";
//    }
}

