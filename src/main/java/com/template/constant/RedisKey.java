package com.template.constant;


/**
 * redis键值存储方式
 */
public class RedisKey {

    //用户token %d用户uid 用户登录后键为uid 值为token
    public static final String LOGIN_USER_TOKEN = "ppgjx:user:token:%s";
    //用户登录后信息存储 %d用户uid 键值为json后的用户信息
    public static final String LOGIN_USER_INFO = "ppgjx:user:info:%s";
    //短信次数
    public static final String SMS = "ppgjx:sms:%s";

}
