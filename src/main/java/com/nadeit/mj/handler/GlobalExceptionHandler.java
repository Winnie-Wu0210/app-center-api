package com.nadeit.mj.handler;

import cn.dev33.satoken.exception.SaTokenException;
import com.nadeit.mj.utils.MyError;
import com.nadeit.mj.utils.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${spring.profiles.active}")
    private String env;

    @ExceptionHandler()
    public Response handlerSaTokenException(Exception e) {

        if (e instanceof MyError) {
            return Response.error(e.getMessage());
        }

        if (e instanceof SaTokenException) {
            return Response.noAuth(e.getMessage());
        }

        if ("dev".equals(env)) {
            return Response.error(e.getMessage());
        } else {
            return Response.error("系统异常");
        }
    }
}
