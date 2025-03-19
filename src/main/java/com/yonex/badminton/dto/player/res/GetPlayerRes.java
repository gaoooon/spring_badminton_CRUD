package com.yonex.badminton.dto.player.res;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPlayerRes {
    private String name;
    private Integer age;
    private String racketName;
}
