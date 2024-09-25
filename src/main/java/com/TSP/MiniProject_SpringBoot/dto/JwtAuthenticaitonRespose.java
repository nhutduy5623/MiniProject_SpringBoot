package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Data;

@Data
public class JwtAuthenticaitonRespose {

    private String token;

    public JwtAuthenticaitonRespose(String token) {
        this.token = token;
    }
}
