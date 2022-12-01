package com.template.common.result;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Description
 * @data 2021/9/21
 * @Author: LiuBin
 * @Modified By:
 */
public class ResultData <T>{
    private Integer pages = 0;
    private Integer page = 0;
    private Integer pageSize = 10;
    private Integer total = 0;
    private T data;

    public ResultData() {

    }

    public ResultData(IPage<T> page,T data) {

        this.setPage((int) page.getPages());
        this.setPageSize((int) page.getSize());
        this.setTotal((int) page.getTotal());
        this.setData(data);
        if (total > 0) {
            this.setPages(total % pageSize != 0 ? total / pageSize + 1 : total / pageSize);
        }
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
