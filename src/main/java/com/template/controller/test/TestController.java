package com.template.controller.test;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.common.result.PageReq;
import com.template.common.result.PageResult;
import com.template.common.result.Result;
import com.template.constant.ResultCode;
import com.template.entity.TestEntity;
import com.template.execption.ResRunException;
import com.template.mapper.TestMapper;
import com.template.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * app全局设置
 *
 * @Author: xjm
 * @Date: 2021/09/14/19:43
 * @Description:
 */
@Controller
@ResponseBody
@RequestMapping(value = "/test")
@Api(tags = "测试")
@Slf4j
public class TestController {

    @Resource
    private TestService testService;


    @ApiOperation(value = "测试")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletResponse response) throws IOException {

        return "test";
    }

    @Resource
    private TestMapper testMapper;

    @ApiOperation(value = "测试登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletResponse response,HttpServletRequest request) throws IOException {
        StpUtil.login("123");
        StpUtil.getSession().set("user","qweqeqwe");
        return (String) StpUtil.getSession().get("user");
    }

    @ApiOperation(value = "测试登录是否有效")
    @RequestMapping(value = "/isLogin",method = RequestMethod.GET)
    @SaCheckLogin
    public String isLogin(HttpServletResponse response) throws IOException {


        return "登录成功";
    }


    @ApiOperation(value = "测试数据库")
    @RequestMapping(value = "/test_mysql",method = RequestMethod.GET)
    public Result<List<TestEntity>> test_mysql(HttpServletResponse response) throws IOException {

        List<TestEntity> testEntities = testMapper.selectTest();

        return Result.success(testEntities);
    }


    @ApiOperation(value = "测试数据库分页")
    @RequestMapping(value = "/test_mysql_page",method = RequestMethod.GET)
    public PageResult<Page<TestEntity>> test_mysql_page(HttpServletResponse response, PageReq req) throws IOException {

        Page<TestEntity> testEntities = testMapper.selectTestPage(new Page<>(req.getPage(), req.getPageSize()));

        return PageResult.success(testEntities);
    }

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value = "测试redis")
    @RequestMapping(value = "/test_redis",method = RequestMethod.GET)
    public Result<String> test_redis(HttpServletResponse response) throws IOException {
        stringRedisTemplate.opsForValue().set("123","123");


        return Result.success(stringRedisTemplate.opsForValue().get("123"));
    }

    @ApiOperation(value = "测试异常")
    @RequestMapping(value = "/exc",method = RequestMethod.GET)
    public Result exc(HttpServletResponse response) throws IOException {

        //throw new ResRunException(ResultCode.PHONE_CODE_EXPIRE_ERR);
        throw new ResRunException(1,"123");
    }

}

