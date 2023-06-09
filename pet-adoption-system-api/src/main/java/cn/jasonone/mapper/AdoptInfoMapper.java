package cn.jasonone.mapper;

import cn.jasonone.bean.AdoptInfo;

/**
* @author miss
* @description 针对表【adopt_info(领养信息表)】的数据库操作Mapper
* @createDate 2023-04-09 15:56:50
* @Entity cn.jasonone.bean.AdoptInfo
*/
public interface AdoptInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AdoptInfo record);

    int insertSelective(AdoptInfo record);

    AdoptInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdoptInfo record);

    int updateByPrimaryKey(AdoptInfo record);

}
