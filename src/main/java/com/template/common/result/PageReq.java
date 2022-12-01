package com.template.common.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xjm
 * @Date: 2021/10/13/19:05
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageReq {

    @ApiModelProperty(
            name = "page",
            value = "当前页码",
            required = true
    )
    @Min(value = 1, message = "当前页码最小为1")
    private Integer page;
    @ApiModelProperty(
            name = "pageSize",
            value = "每页显示条数",
            required = true
    )
    @Min(value = 1, message = "每页显示条数最小为1")
    @Max(value = 50, message = "每页显示条数最大为50")
    private Integer pageSize;

}
