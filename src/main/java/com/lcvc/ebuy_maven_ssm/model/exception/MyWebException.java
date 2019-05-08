package com.lcvc.ebuy_maven_ssm.model.exception;

/**
 * 自定义web的异常
 * 用于抛出业务异常
 */
public class MyWebException extends RuntimeException{
    public MyWebException() {
        super();
    }

    public MyWebException(String message) {
        super(message);
    }

    public MyWebException(String message, Throwable cause) {
        super(message, cause);
    }



    public MyWebException(Throwable cause) {
        super(cause);
    }
}
