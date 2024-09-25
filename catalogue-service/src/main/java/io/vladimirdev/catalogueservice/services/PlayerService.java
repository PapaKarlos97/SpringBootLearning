package io.vladimirdev.catalogueservice.services;

import io.vladimirdev.catalogueservice.entities.Player;
import io.vladimirdev.catalogueservice.repositories.PlayersRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;
import java.util.Optional;

@Service@RequiredArgsConstructor@Transactional
public class PlayerService {
    private  final PlayersRepo playersRepo;
    private static final Logger logger=  LoggerFactory.getLogger(PlayerService.class);

@Transactional(propagation = Propagation.NESTED,isolation = Isolation.REPEATABLE_READ)
public void sendMoney(int idSender, int idRecipient, int amount) {
    logger.info("TX IN>>>>>");
    Player recipient;
    Player sender = playersRepo.findById(idSender)
            .orElseThrow(() -> new UsernameNotFoundException("Sender not found: " + idSender));
    sender.setBalance(sender.getBalance() - amount);
    playersRepo.save(sender);
    try {
        recipient = playersRepo.findById(idRecipient)
                .orElseThrow(() -> new UsernameNotFoundException("Recipient not found: " + idRecipient));
    }catch (UsernameNotFoundException e) {
    throw new  UsernameNotFoundException("Recipient not found: " + idRecipient);
    }
    // Проверка достаточности баланса отправителя
    if (sender.getBalance() < amount) {
        throw new IllegalArgumentException("Insufficient balance for transaction");
    }

    // Выполнение перевода

    recipient.setBalance(recipient.getBalance() + amount);

    // Сохранение изменений

    playersRepo.save(recipient);
    logger.info("TX OUT<<<<<");
}

    public Optional<Player> findByUsername(String username) {
        return playersRepo.findByName(username);

    }

    public Optional<Player> findByMail(String mail) {
        return playersRepo.findByEmail(mail);

    }
}
