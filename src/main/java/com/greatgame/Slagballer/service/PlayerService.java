package com.greatgame.Slagballer.service;

import com.greatgame.Slagballer.exception.PlayerNotFoundException;
import com.greatgame.Slagballer.model.Player;
import com.greatgame.Slagballer.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
@Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Player addPlayer(Player player) {
    player.setPlayerCode(UUID.randomUUID().toString());
    return playerRepository.save(player);
}

public List<Player> findAllPlayers(){
        return playerRepository.findAll();
}

public Player updatePlayer(Player player){
        return playerRepository.save(player);
}
public void deletePlayer(Long id){
        playerRepository.deletePlayerById(id);
}
public Player findPlayerById(Long id) {
        return playerRepository.findPlayerById(id).orElseThrow(() -> new PlayerNotFoundException("Player by ID was not found"));
}

}