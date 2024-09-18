package io.vladimirdev.catalogueservice.services;

import io.vladimirdev.catalogueservice.entities.Player;
import io.vladimirdev.catalogueservice.repositories.PlayersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.Optional;

@Service@RequiredArgsConstructor
public class PlayerService {
    private final PlayersRepo playersRepo;

    public Optional<Player> findByUsername(String username) {
        return playersRepo.findByName(username);

    }

    public Optional<Player> findByMail(String mail) {
        return playersRepo.findByEmail(mail);

    }
}
