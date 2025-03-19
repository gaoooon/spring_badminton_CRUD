package com.yonex.badminton.dto.racket.res;

import com.yonex.badminton.entity.RacketType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetRacketRes {
    private Long id;
    private String name;
    private RacketType type;
}
