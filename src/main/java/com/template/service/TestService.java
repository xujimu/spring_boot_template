package com.template.service;





import com.baomidou.mybatisplus.extension.service.IService;
import com.template.entity.TestEntity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.common.result.PageReq;

/**
 * 测试表(Test)表服务接口
 *
 * @author makejava
 * @since 2022-12-04 01:16:23
 */
public interface TestService extends IService<TestEntity> {
     /**
     * 搜索分页查询
     *
     * @param req 页数
     * @param testEntity 类实体
     * @return 查询结果
     */
    Page<TestEntity> search(PageReq req,TestEntity testEntity);


}

