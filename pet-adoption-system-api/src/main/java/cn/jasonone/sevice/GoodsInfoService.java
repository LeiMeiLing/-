package cn.jasonone.sevice;

import cn.jasonone.bean.GoodsInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsInfoService {
    PageInfo<GoodsInfo> selectAll(int pageNum, int pageSize);
}
