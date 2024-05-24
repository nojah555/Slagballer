package com.greatgame.Slagballer;

import com.greatgame.Slagballer.model.Player;
import com.greatgame.Slagballer.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerResource {
    private final PlayerService playerService;
@GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers(){
    List<Player> players = playerService.findAllPlayers();
    return new ResponseEntity<>(players, HttpStatus.OK);
}
@GetMapping("/find/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id")Long id){
    Player player = playerService.findPlayerById(id);
    return new ResponseEntity<>(player, HttpStatus.OK);
}
@PostMapping("/add")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
    Player player1 = playerService.addPlayer(player);
    return new ResponseEntity<>(player, HttpStatus.CREATED);
}

@PutMapping("/update")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
    Player updatePlayer = playerService.updatePlayer(player);
    return new ResponseEntity<>(updatePlayer,HttpStatus.OK);
}
@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
    playerService.deletePlayer(id);
    return new ResponseEntity<>(HttpStatus.OK);
}

}
