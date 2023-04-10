package cn.jasonone.service;

import cn.jasonone.bean.PetInfo;
import com.github.pagehelper.PageInfo;

public interface PetInfoService {
    PageInfo<PetInfo> findAll(int pageNum, int pageSize);
}
