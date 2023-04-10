package cn.jasonone.service.impl;

import cn.jasonone.bean.PetInfo;
import cn.jasonone.mapper.PetInfoMapper;
import cn.jasonone.service.PetInfoService;
import cn.jasonone.util.MyBatisUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PetInfoServiceImpl implements PetInfoService {
    @Override
    public PageInfo<PetInfo> findAll(int pageNum, int pageSize) {
        PetInfoMapper mapper = MyBatisUtil.getSession().getMapper(PetInfoMapper.class);
        List<PetInfo> petInfos = mapper.selectAll();
        return new PageInfo<>(petInfos);

    }
}
