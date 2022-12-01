package com.template.common.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;

/**
 * @Description 分页公共返回类
 * @data 2021/9/21
 * @Author: LiuBin
 * @Modified By:
 */
public class PageResult<T> {
    private Integer code;
    private String msg;
    private ResultData data = new ResultData();

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultData getData() {
        return this.data;
    }

    public void setData(ResultData data) {
        this.data = data;
    }

    public PageResult() {
    }

    public PageResult(Integer code, String msg, T data, Integer pages,Integer page, Integer pageSize, Integer total) {
        this.code = code;
        this.msg = msg;
        this.data.setPages(pages);
        this.data.setPageSize(pageSize);
        this.data.setTotal(total);
        this.data.setData(data);
        this.data.setPage(page);

    }

    public PageResult(String msg) {
        this.code = -1;
        this.msg = msg;
    }

    public static <T> PageResult<T> success(T data) {
        if (data instanceof Page) {
            Page<T> page = (Page) data;
            return new PageResult(200, "操作成功", data,page.getPages(), page.getPageNum(), page.getPageSize(), (int) page.getTotal());
        }else if (data instanceof IPage){
            IPage<T> page=(IPage)data;
            return new PageResult(200,"操作成功",page.getRecords(),(int) page.getPages(),(int) page.getCurrent(),(int) page.getSize(),(int) page.getTotal());
        }else {
            return null;
        }
    }

    public static PageResult error(String msg) {
        return new PageResult(msg);
    }
}
