package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseDTO<T> {
    private String message;
    private T result;
    private List<T> listResults = new ArrayList<>();

    public ResponseDTO(String message, T result) {
        this.message = message;
        this.result = result;
    }

    public ResponseDTO(String message, List<T> listResults) {
        this.message = message;
        this.listResults = listResults;
    }
}
