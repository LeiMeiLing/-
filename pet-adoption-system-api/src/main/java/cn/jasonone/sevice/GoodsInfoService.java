package cn.jasonone.sevice;

import cn.jasonone.bean.GoodsInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsInfoService {
    //查询所有并分页
    PageInfo<GoodsInfo> findAll(int pageNum, int pageSize);
}
