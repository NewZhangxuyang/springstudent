package com.tc.zxy.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
    private HttpStatus code;
    private String message;
    private Boolean success;
}
