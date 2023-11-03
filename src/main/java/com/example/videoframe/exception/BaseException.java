package com.example.videoframe.exception;

/**
 * @Author: `sujinwang`
 * @Date: `2022/2/28 16:28`
 * @Version: 1.0
 * @Description:
 */
public class BaseException extends RuntimeException{

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
