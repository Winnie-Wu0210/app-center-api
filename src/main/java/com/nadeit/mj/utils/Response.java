package com.nadeit.mj.utils;

import lombok.Data;

@Data
public class Response<T> {

    private Integer code;
    private String msg;

    private T data;

    Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>(200, "success");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success(T data, String msg) {
        Response<T> response = new Response<>(200, msg);
        response.setData(data);
        return response;
    }


    public static Response error(String msg) {
        return new Response(500, msg);
    }

    //没有权限
    public static Response noAuth(String msg) {
        return new Response(401, msg);
    }
}
