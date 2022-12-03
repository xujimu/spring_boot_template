package com.template.service.impl;





import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.template.dao.TestDao;
import com.template.entity.TestEntity;
import com.template.service.TestService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.common.result.PageReq;
import com.template.dao.TestDao;
import javax.annotation.Resource;
/**
 * 测试表(Test)表服务实现类
 *
 * @author makejava
 * @since 2022-12-04 01:16:22
 */
@Service("testService")
public class TestServiceImpl extends ServiceImpl<TestDao, TestEntity> implements TestService {

    @Resource
    private TestDao testDao;

     /**
     * 搜索分页查询
     *
     * @param req 页数
     * @param testEntity 类实体
     * @return 查询结果
     */
    @Override
    public Page<TestEntity> search(PageReq req, TestEntity testEntity) {

        Page<TestEntity> page = new Page<>(req.getPage(),req.getPageSize());

        return testDao.search(page,testEntity);
    }
}

