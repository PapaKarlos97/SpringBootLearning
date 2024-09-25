package io.vladimirdev.catalogueservice.controllers;

import io.vladimirdev.catalogueservice.entities.Player;
import io.vladimirdev.catalogueservice.services.PlayerService;
import io.vladimirdev.catalogueservice.utils.TransferForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;


@Controller()@RequiredArgsConstructor
public class ThymeLeafContr {
    private final PlayerService playerService;
@GetMapping("c-p")
    public String changePass() {
    return "changepass";
}
@GetMapping("/send")
    String send(Model model) {
    model.addAttribute("transferForm", new TransferForm());
    return "sendmoney";
}
    @PostMapping("/send")
    public String processTransfer(@Valid @ModelAttribute("transferForm") TransferForm transferForm,
                                  BindingResult result, Model model,@AuthenticationPrincipal Player player,
                                  @RequestParam ("id")int toId, @RequestParam("sum") int addSum) {
//        if (result.hasErrors()) {
//            return "sendmoney";  // Возвращаем форму с ошибками
//        }
        try {
            int fromId = player.getId();
            playerService.sendMoney(fromId,toId,addSum);

        }catch (IllegalArgumentException e){
            model.addAttribute("lowBalance", e.getMessage());
            System.out.println(e.getMessage());
            return "sendmoney";
        }catch (UsernameNotFoundException e){
            System.out.println(e.getMessage());
            model.addAttribute("wrongId", e.getMessage());
            return "sendmoney";
        }
        if (result.hasErrors()) {
            return "sendmoney";  // Возвращаем форму с ошибками
        }

        // Логика перевода
        return "redirect:/success";
    }
    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
