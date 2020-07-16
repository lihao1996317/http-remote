package com.example.exp.vo;

import lombok.Data;

/**
 * ResultVo
 *
 * @author xzr
 * 2020/7/14 15:19
 **/
@Data
public class ResultVo<T> {

    private Integer code;

    private String message;

    private T data;

    public ResultVo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVo(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
