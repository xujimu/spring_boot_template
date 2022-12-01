package com.template.execption;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.util.SaResult;
import com.alibaba.fastjson.JSON;
import com.template.common.result.Result;
import com.template.constant.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 控制器异常处理
 * @date 2018/9/14
 * @version V1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {


    @ExceptionHandler(BindException.class)
    public Result BindException(BindException e) {
        Map<String, Object> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            FieldError fieldError = (FieldError) error;
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errors.put(field, message);
        });
        log.info(JSON.toJSONString(errors));
        String errorMsg = "参数不正确";
        if (errors.size() > 0) {
            errorMsg = errors.values().toArray()[0].toString();
        }
        e.printStackTrace();
        return Result.error(ResultCode.SERVER_BIND_ERR.getCode(),errorMsg, errors);
    }


    // 全局异常拦截
    @ExceptionHandler(SaTokenException.class)
    public SaResult SaTokenException(SaTokenException e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, Object> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            FieldError fieldError = (FieldError) error;
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errors.put(field, message);
        });
        log.info(JSON.toJSONString(errors));
        String errorMsg = "参数不正确";
        if (errors.size() > 0) {
            errorMsg = errors.values().toArray()[0].toString();
        }
        e.printStackTrace();
        return Result.error(ResultCode.SERVER_METHOD_ARGUMENT_NOT_VALID_ERR.getCode(),errorMsg, errors);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        Map<String, Object> errors = new HashMap<>();
        errors.put(e.getParameterName(), "不能为空");
        e.printStackTrace();
        return Result.error(ResultCode.SERVER_MISSING_SERVLET_REQUEST_PARAMETER_ERR.getCode(),"参数不正确",errors);
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public Result handleServletRequestBindingException(ServletRequestBindingException e) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("error", e.getMessage());
        e.printStackTrace();
        return  Result.error(ResultCode.SERVER_SERVLET_REQUEST_BINDING_ERR.getCode(),"参数不正确",errors);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        Map<String, Object> errors = new HashMap<>();
        MediaType mediaType = e.getContentType();
        e.printStackTrace();
        errors.put(mediaType.getType() + "/" + mediaType.getSubtype(), "不支持");
        return  Result.error(ResultCode.SERVER_HTTP_MEDIA_TYPE_NOT_SUPPORTED_ERR.getCode(), "参数类型不正确",errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("error", "参数缺失");
        e.printStackTrace();
        return Result.error(ResultCode.SERVER_HTTP_MESSAGE_NOT_READABLE_ERR.getCode(),"参数不正确",errors);
    }

    //其他返回状态码异常
    @ExceptionHandler(ResRunException.class)
    public Result codeException(ResRunException e) {
        e.printStackTrace();
        return Result.error(e.getCode(),e.getMsg(),e.getData());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Exection(Exception e){
        e.printStackTrace();
        return Result.error(ResultCode.SERVER_ERR.getCode(),e.getMessage());
    }


    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Result RuntimeException(RuntimeException e){
        log.info( e.getMessage());
        e.printStackTrace();
        return Result.error(ResultCode.SERVER_RUN_ERR.getCode(),e.getMessage());
    }



}
