package io.vladimirdev.catalogueservice.configs;

import io.vladimirdev.catalogueservice.entities.Player;
import io.vladimirdev.catalogueservice.repositories.PlayersRepo;
import io.vladimirdev.catalogueservice.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor@Service
public class PlayerDetailServices implements UserDetailsService {
    private final PlayerService playerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            var player=new Player();
            try {
            if (playerService.findByUsername(username).isPresent()){
                return player=playerService.findByUsername(username).get();
            }else if (playerService.findByMail(username).isPresent()){
                return player=playerService.findByMail(username).get();
            }

    }catch (UsernameNotFoundException e){
                new UsernameNotFoundException("Name or password is incorrect");
            }
            return null;
    }

}
