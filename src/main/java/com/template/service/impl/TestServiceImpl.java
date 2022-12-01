package com.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.template.entity.TestEntity;
import com.template.service.TestService;
import com.template.mapper.TestMapper;
import org.springframework.stereotype.Service;

/**
* @author xjm
* @description 针对表【test(测试表)】的数据库操作Service实现
* @createDate 2022-12-01 22:52:12
*/
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity>
    implements TestService{

}




