package com.learn.spl.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author created by zzz at 2019/10/29 17:35
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {

    private String errorCode;

    private String message;

    private T data;

    private ResponseResult() {
        //empty
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseResult success() {
        return success("SUCCESS", "Success");
    }

    public static ResponseResult success(String code, String message) {
        return build(code, message, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return build("SUCCESS", "Success", data);
    }

    public static ResponseResult failed() {
        return failed("FAILED", "failed");
    }

    public static ResponseResult failed(String code, String message) {
        return failed(code, message, null);
    }

    public static <T> ResponseResult<T> failed(String code, String message, T data) {
        return build(code, message, data);
    }

    public static <T> ResponseResult<T> build(String code, String message, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.errorCode = code;
        responseResult.message = message;
        responseResult.data = data;
        return responseResult;
    }
}
