package com.template.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.template.entity.TestEntity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 测试表(Test)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-04 01:16:21
 */
public interface TestDao extends BaseMapper<TestEntity> {

    /**
    * 批量新增数据（MyBatis原生foreach方法）
    *
    * @param entities List<TestEntity> 实例对象列表
    * @return 影响行数
    */
    int insertBatch(@Param("entities") List<TestEntity> entities);

    /**
    * 批量新增或按主键更新数据（MyBatis原生foreach方法）
    *
    * @param entities List<TestEntity> 实例对象列表
    * @return 影响行数
    * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
    */
    int insertOrUpdateBatch(@Param("entities") List<TestEntity> entities);


    /**
    *  根据实体查进行搜索查询 只使用于String字段和 Integer 类型 其他类型传入无效
    *  每个字段使用or链接条件
    * @param
    * @return
    * @throws
    */
   Page<TestEntity> search(Page<TestEntity> page,@Param("map") TestEntity entity);
}

