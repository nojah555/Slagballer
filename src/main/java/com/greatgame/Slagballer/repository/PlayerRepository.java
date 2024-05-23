package com.greatgame.Slagballer.repository;

import com.greatgame.Slagballer.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
