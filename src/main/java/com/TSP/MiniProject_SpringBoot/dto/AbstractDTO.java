package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public abstract class AbstractDTO<T> {
    private Long id;
    private String code;
    private String createdBy;
    private Date createdDate;
    private String modifyBy;
    private Date modifyDate;
    private String message;
    private List<T> listResults = new ArrayList<>();
    private Integer totalPages=1;
    private Integer nextPage = 1;
    private Integer limit = 4;
    private String searchValue;
    private Integer status = 1;
}
