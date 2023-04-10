package cn.jasonone.service;

import cn.jasonone.bean.GoodsInfo;
import com.github.pagehelper.PageInfo;

public interface GoodsInfoService {
    //查询所有并分页
    PageInfo<GoodsInfo> findAll(int pageNum, int pageSize);
}
