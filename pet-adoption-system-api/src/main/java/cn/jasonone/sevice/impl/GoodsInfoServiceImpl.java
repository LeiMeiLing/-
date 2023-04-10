package cn.jasonone.sevice.impl;

import cn.jasonone.bean.GoodsInfo;
import cn.jasonone.mapper.GoodsInfoMapper;
import cn.jasonone.sevice.GoodsInfoService;
import cn.jasonone.util.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class GoodsInfoServiceImpl implements GoodsInfoService {
    private GoodsInfoMapper gim;
    @Override
    public PageInfo<GoodsInfo> findAll(int pageNum, int pageSize) {
        GoodsInfoMapper goodsInfoMapper = MyBatisUtil.getSession().getMapper(GoodsInfoMapper.class);
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsInfo> goods = goodsInfoMapper.selectAll();
        return new PageInfo<>(goods);
    }
}
