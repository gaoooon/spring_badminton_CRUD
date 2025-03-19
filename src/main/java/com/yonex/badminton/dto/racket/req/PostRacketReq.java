package com.yonex.badminton.dto.racket.req;

import com.yonex.badminton.entity.RacketType;
import lombok.Data;

@Data
public class PostRacketReq {
    private String name;
    private RacketType type;
}
