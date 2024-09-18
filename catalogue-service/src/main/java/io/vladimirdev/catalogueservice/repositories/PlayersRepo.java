package io.vladimirdev.catalogueservice.repositories;

import io.vladimirdev.catalogueservice.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayersRepo extends JpaRepository<Player,Integer> {
    Optional<Player>findByName(String name);

    Optional<Player> findByEmail(String mail);
}
