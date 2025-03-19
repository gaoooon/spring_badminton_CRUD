package com.yonex.badminton.service;

import com.yonex.badminton.dto.racket.req.PostRacketReq;
import com.yonex.badminton.dto.racket.res.GetRacketRes;
import com.yonex.badminton.entity.Racket;
import com.yonex.badminton.repository.RacketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacketService {
    @Autowired
    RacketRepository racketRepository;

    public List<GetRacketRes> getRackets() {
        return racketRepository.findAll().stream().map(racket -> new GetRacketRes(racket.getId(), racket.getName(), racket.getType())).toList();
    }

    public GetRacketRes getRacketById(Long id) {
       Racket racket =  racketRepository.findById(id).orElse(null);

        return new GetRacketRes(racket.getId(), racket.getName(), racket.getType());
    }

    public Racket postRacket(PostRacketReq body) {
        Racket newRacket = new Racket(body.getName(), body.getType());

        return racketRepository.save(newRacket);
    }

}
