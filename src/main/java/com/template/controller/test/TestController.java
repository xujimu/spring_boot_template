package com.template.controller.test;








import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.constant.ResultCode;
import com.template.entity.TestEntity;
import com.template.execption.ResRunException;
import com.template.service.TestService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.template.common.result.PageResult;
import com.template.common.result.PageReq;
import io.swagger.annotations.Api;
import com.template.common.result.Result;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import io.swagger.annotations.ApiOperation;
/**
 * 测试表(Test)表控制层
 *
 * @author makejava
 * @since 2022-12-04 01:16:21
 */
@RestController
@Api(tags = "test")
@RequestMapping("/test")
public class TestController {
    /**
     * 服务对象
     */
    @Resource
    private TestService TestService;


     /**
     *
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @ApiOperation(value = "分页带条件查询所有数据")
    public PageResult<Page<TestEntity>> search(PageReq req, TestEntity testEntity) {
        return PageResult.success(this.TestService.search(req, testEntity));
    }




    @RequestMapping(value = "/queryId",method = RequestMethod.GET)
    @ApiOperation(value = "通过主键查id")
    public Result<TestEntity> selectOne(@RequestParam("id") Serializable id) {

        TestEntity testEntity = TestService.getBaseMapper().selectById(id);
        return Result.success(testEntity);
    }



    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "新增数据")
    public Result add(@RequestBody  TestEntity testEntity) {

        TestService.save(testEntity);
        return Result.success();
    }


    @RequestMapping(value = "/updateId",method = RequestMethod.POST)
    @ApiOperation(value = "通过主键修改数据")
    public Result updateId(@RequestBody TestEntity testEntity) {
        this. TestService.updateById(testEntity);
        return Result.success();
    }


    @RequestMapping(value = "/deleteId",method = RequestMethod.POST)
    @ApiOperation(value = "删除指定id数据")
    public Result deleteId(@RequestParam("id") Serializable id) {
        this. TestService.removeById(id);
        return Result.success();
    }


    @Resource
    private TestService testService;


    @ApiOperation(value = "测试")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletResponse response) throws IOException {

        return "test";
    }


    @ApiOperation(value = "测试登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletResponse response, HttpServletRequest request) throws IOException {
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

        throw new ResRunException(ResultCode.PHONE_CODE_EXPIRE_ERR);
    }

}