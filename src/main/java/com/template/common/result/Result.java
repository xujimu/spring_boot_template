package com.template.common.result;


import com.template.constant.ResultCode;

/**
 * @Descri2021/9/21
 * @Autption 公共返回类
 *  * @data hor: LiuBin
 * @Modified By:
 */
public class Result<T> {
    private Integer code = ResultCode.ERR.getCode() ;
    private String msg;
    private T data;

    Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    Result(T data) {
        this.data = data;
    }

    Result(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    Result(String msg,T data) {
        this.data = data;
        this.msg = msg;
    }

    public Result() {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result error(String msg) {
        return new Result(ResultCode.ERR.getCode(), msg);
    }

    public static <T> Result<T>  error(Integer code,String msg,T data) {
        return new Result(code, msg,data);
    }
    public static <T> Result<T>  error(Integer code,String msg) {
        return new Result(code, msg);
    }

    public static <T> Result<T> error(T data, String msg) {
        return new Result(msg, data);
    }

    public static <T> Result<T> error(String msg,T data) {
        return new Result(msg, data);
    }

    public static <T> Result<T> success(T data) {
        return new Result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success() {
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
    }


}
