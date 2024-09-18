package io.vladimirdev.catalogueservice.configs;

import io.vladimirdev.catalogueservice.entities.Player;
import io.vladimirdev.catalogueservice.repositories.PlayersRepo;
import io.vladimirdev.catalogueservice.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerDetailServices implements UserDetailsService {

    private final PlayerService playerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return playerService.findByUsername(username)
                .or(() -> playerService.findByMail(username))
                .orElseThrow(() -> new UsernameNotFoundException("Name or email not found: " + username));
    }
}
