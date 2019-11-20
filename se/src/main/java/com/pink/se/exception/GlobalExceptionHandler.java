package com.pink.se.exception;


import com.pink.se.response.RespBean;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageConversionException.class)
    public RespBean requestFormatException(HttpMessageConversionException e){
        if (e instanceof HttpMessageNotReadableException ){
            return RespBean.fail("请求参数有误,请检查参数");
        }

        return RespBean.fail("请求出现问题，请检查参数");


    }
}
