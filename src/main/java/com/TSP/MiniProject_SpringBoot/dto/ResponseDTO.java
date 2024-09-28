package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ResponseDTO<T> {
    private String message;
    private String status;
    private T result;
    private List<T> listResults = new ArrayList<>();

    public ResponseDTO() {
    }

    public ResponseDTO(String message, T result) {
        this.message = message;
        this.result = result;
    }

    public ResponseDTO(String message, List<T> listResults) {
        this.message = message;
        this.listResults = listResults;
    }

    public ResponseDTO<T> validateResponse(BindingResult bindingResult){
        this.setStatus("200");
        if (bindingResult.hasErrors()) {
            this.setStatus("400");
            this.setMessage(bindingResult.getFieldErrors()
                    .stream()
                    .map(e -> e.getField() + ": " + e.getDefaultMessage())
                    .collect(Collectors.joining(", ")));
        }
        return this;
    }
}
