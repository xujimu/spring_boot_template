package com.template.constant;

/**
 * @Description 返回参数枚举状态
 * @data 2019/7/8 16:05
 * @Author: LiuBin
 * @Modified By:
 */
public enum ResultCode {
    /*成功*/
    SUCCESS(200, "成功"),

    ERR(404, "操作失败"),
    AUTH_ERR(405, "权限错误"),
    /*500 - 599 异常错误*/
    SERVER_ERR(500, "服务器错误"),
    SERVER_RUN_ERR(501, "服务器运行错误"),
    SERVER_BIND_ERR(502, "BindException"),
    SERVER_METHOD_ARGUMENT_NOT_VALID_ERR(503, "MethodArgumentNotValidException"),
    SERVER_MISSING_SERVLET_REQUEST_PARAMETER_ERR(504, "MissingServletRequestParameterException"),
    SERVER_SERVLET_REQUEST_BINDING_ERR(505, "ServletRequestBindingException"),
    SERVER_HTTP_MEDIA_TYPE_NOT_SUPPORTED_ERR(506, "HttpMediaTypeNotSupportedException"),
    SERVER_HTTP_MESSAGE_NOT_READABLE_ERR(507, "HttpMessageNotReadableException"),
    ALI_PAY_CALL_ERR(508, "支付宝支付调用失败"),
    WX_PAY_CALL_ERR(509, "微信支付下单失败"),
    WX_PAY_SIGN_ERR(510, "微信支付回调通知签名错误"),
    SERVER_RATE_ERR(511, "当前人太多了 请稍后再试 靓仔!"),
    AMOUNT_ERR(512, "皮皮豆不足"),
    COUNT_ERR(520, "次数不足"),

    /*1000 - 1999 用户逻辑错误*/
    PASSWORD_ERR(10001, "密码错误"),
    OTHER_LOGIN_ERR(10002, "账号在其他地方登录"),
    NOT_LOGIN_ERR(10003, "请登录"),
    USER_DISABLED_ERR(10004, "您已被封禁"),
    ACCOUNT_EXIST_ERR(10005, "账号已存在"),
    PASSWORD_OR_ACCOUNT_ERR(10006, "密码或账号错误"),
    IMG_VIOLATION_ERR(10007, "图片违规"),
    IMG_VERIFY_ERR(10008, "图片上传失败"),
    SMS_SEND_ERR(10009,"验证码发送失败 请联系客服"),
    SMS_SEND_SUM_ERR(10010,"今日验证码发送已达上限"),
    PHONE_BIND_CODE_ERR(10011,"验证码错误"),
    PHONE_CODE_EXPIRE_ERR(10012,"验证码已过期"),
    GET_LOCATION_ERR(10013,"无法获取您的位置信息"),
    USER_TAKE_A_SHOT_STATE_ERR(10015,"用户未开启在线状态"),
    USER_ICON_MIN_ERR(10016,"图片太小了"),
    USER_WP_MACHINE_ERR(10017,"机器审核中不可更改"),
    USER_WP_REMOVE_ERR(10018,"不允许删除用户壁纸"),
    USER_WP_NAME_ERR(10019,"壁纸名不合法"),
    USER_WP_REVIEW_EXPLAIN_ERR(10020,"理由不能为空"),
    DAILY_ERR(10021,"日报获取失败"),
    WP_MD5_ERR(10022,"壁纸已存在"),
    USER_LOGOUT_REPETITION_ERR(10023,"申请已提交请勿重新提交"),
    PHONE_EXIST_ERR(10024,"用户已存在"),
    NO_BIND_PHONE_ERR(10025,"请先绑定手机号");


    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
