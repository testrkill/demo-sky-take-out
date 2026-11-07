package com.sky.handler;

import com.sky.exception.BaseException;
import lombok.extern.slf4j.Slf4j;

import com.sky.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    public Result globalExceptionHander(BaseException ex){
        log.error(ex.getMessage());
        return Result.error(ex.getMessage());
    }
}
