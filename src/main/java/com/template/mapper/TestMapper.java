package com.template.mapper;
import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.entity.TestEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author xjm
* @description 针对表【test(测试表)】的数据库操作Mapper
* @createDate 2022-12-01 22:52:12
* @Entity com.template.entity.TestEntity
*/
public interface TestMapper extends BaseMapper<TestEntity> {

    List<TestEntity> selectTest();

    Page<TestEntity> selectTestPage(@Param("page") Page page);

}




