package com.zilin.myspringtest.util;

import com.zilin.myspringtest.jsonbean.ErrorInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.UnexpectedTypeException;

@ControllerAdvice
@ResponseBody
@Log4j2
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorInfo MethodArgumentNotValidHandler(MethodArgumentNotValidException exception){
        ErrorInfo errorInfo = new ErrorInfo(exception.getBindingResult().getFieldError().getField(),exception.getBindingResult().getFieldError().getDefaultMessage());
        errorInfo.setCode(CodeInfo.DATAERROR.getCode());
        errorInfo.setMsg(CodeInfo.DATAERROR.getMsg());
        log.info("Error info: " + errorInfo.toString());
        return errorInfo;
    }
}
