package com.template.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 测试表(Test)实体类
 *
 * @author makejava
 * @since 2022-12-04 02:06:20
 */
@TableName(value = "test")
@Data
public class TestEntity implements Serializable {

    @ApiModelProperty(value = "")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "")
    @TableField(value = "name")
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = -41980683856537683L;
}
