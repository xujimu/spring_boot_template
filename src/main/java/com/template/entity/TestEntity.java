package com.template.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 测试表
 * @TableName test
 */
@TableName(value ="test")
@Data
public class TestEntity implements Serializable {
    /**
     * 
     */
    @TableField(value = "test")
    private String test;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}