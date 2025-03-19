package com.yonex.badminton.service;

import com.yonex.badminton.dto.player.req.PostPlayerReq;
import com.yonex.badminton.dto.player.req.PutPlayerReq;
import com.yonex.badminton.dto.player.res.GetPlayerRes;
import com.yonex.badminton.dto.racket.res.GetRacketRes;
import com.yonex.badminton.entity.Player;
import com.yonex.badminton.entity.Racket;
import com.yonex.badminton.entity.RacketType;
import com.yonex.badminton.repository.PlayerRepository;
import com.yonex.badminton.repository.RacketRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RacketService racketService;

    @Autowired
    RacketRepository racketRepository;

    public List<GetPlayerRes> getPlayers() {
        return playerRepository.findAll().stream().map(player -> getPlayerById(player.getId())).toList();
    }

    public GetPlayerRes getPlayerById(Long id) {
        Player player =  playerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 ID의 player가 없습니다: " + id));
        GetRacketRes racket = racketService.getRacketById(id);

        return new GetPlayerRes(player.getName(), player.getAge(), racket.getName());
    }

    @Transactional
    public void postPlayer(PostPlayerReq body) {
        Racket racket = new Racket("hihi", RacketType.HEAD_HEAVY);
        Player newPlayer = new Player(body.getName(), body.getAge(), racket);
        playerRepository.save(newPlayer);
    }

    @Transactional
    public void putPlayerById(Long id, PutPlayerReq body) {
        Player player = playerRepository.findById(id).orElseThrow();
        Racket racket = racketRepository.findById(id).orElseThrow();

        player.setName(body.getName());
        player.setAge(body.getAge());
        player.setRacket(racket);
        playerRepository.save(player);
    }

    @Transactional
    public void deletePlayers() {
        playerRepository.deleteAll();
    }

    @Transactional
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
