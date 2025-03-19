package com.yonex.badminton.dto.player.req;

import lombok.Data;

@Data
public class PostPlayerReq {
    private String name;
    private Integer age;
    private Long racketId;
}
