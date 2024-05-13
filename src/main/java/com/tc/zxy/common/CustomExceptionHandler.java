package com.tc.zxy.common;

import com.tc.zxy.common.exception.ResponseMessage;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ResponseMessage> handleException(HttpServletResponse response, Exception e) {
        return new ResponseEntity<>(new ResponseMessage(HttpStatus.NOT_FOUND, e.getMessage(), false), HttpStatus.NOT_FOUND);
    }

}
