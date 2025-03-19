package com.yonex.badminton.controller;

import com.yonex.badminton.dto.player.req.PostPlayerReq;
import com.yonex.badminton.dto.player.req.PutPlayerReq;
import com.yonex.badminton.dto.player.res.GetPlayerRes;
import com.yonex.badminton.entity.Player;
import com.yonex.badminton.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/player")
    public List<GetPlayerRes> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/player/{id}")
    public GetPlayerRes getPlayerById(@PathVariable("id") Long id) { return playerService.getPlayerById(id); }

    @PostMapping("/player")
    public void postPlayer(@RequestBody PostPlayerReq body) {
        playerService.postPlayer(body);
    }

    @PutMapping("/player/{id}")
    public void putPlayerById(@PathVariable("id") Long id, @RequestBody PutPlayerReq body) { playerService.putPlayerById(id,body); }

    @DeleteMapping("/player")
    public void deletePlayers() {
        playerService.deletePlayers();
    }

    @DeleteMapping("/player/{id}")
    public void deletePlayerById(@PathVariable("id") Long id) {
        playerService.deletePlayerById(id);
    }
}
