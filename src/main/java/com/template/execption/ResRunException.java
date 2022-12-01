package com.template.execption;

import com.template.constant.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 其他状态码异常
 *
 * @Author: xjm
 * @Date: 2021/09/15/18:47
 * @Description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResRunException extends RuntimeException{

    private Integer code;
    private String msg;
    private Object data ;

    public ResRunException(ResultCode e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    public ResRunException(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ResRunException(ResultCode e,String msg) {
        this.code = e.getCode();
        this.msg = msg;
    }

    public ResRunException(String msg) {
        this.code = ResultCode.SERVER_RUN_ERR.getCode();
        this.msg = msg;
    }
}
