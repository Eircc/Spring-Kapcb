package com.kapcb.ccc.commons.domain;

import com.kapcb.ccc.commons.constant.ResultInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * <a>Title: Result </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-15:01
 */
@Data
@SuppressWarnings("serial")
public class Result<T> implements Serializable {

    private String message;
    private String code;
    private T data;

    public Result() {
    }

    public Result(String message, String code) {
        this.message = message;
        this.code = code;
        this.data = null;
    }

    public Result(String message, String code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public Result(ResultInfo resultInfo) {
        this.message = resultInfo.getMessage();
        this.code = resultInfo.getCode();
        this.data = null;
    }

    public Result(ResultInfo resultInfo, T data) {
        this.message = resultInfo.getMessage();
        this.code = resultInfo.getCode();
        this.data = data;
    }
}
