package com.yonex.badminton.controller;


import com.yonex.badminton.dto.racket.req.PostRacketReq;
import com.yonex.badminton.dto.racket.res.GetRacketRes;
import com.yonex.badminton.entity.Racket;
import com.yonex.badminton.service.RacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RacketController {
    @Autowired
    RacketService racketService;

    @GetMapping("/racket")
    public List<GetRacketRes> getRackets() {
        return racketService.getRackets();
    }

    @GetMapping("/racket/{id}")
    public GetRacketRes getRacketById(@PathVariable("id") Long id) {
        return racketService.getRacketById(id);
    }

    @PostMapping("/racket")
    public Racket postRacket(@RequestBody PostRacketReq body) {
        return racketService.postRacket(body);
    }
}
