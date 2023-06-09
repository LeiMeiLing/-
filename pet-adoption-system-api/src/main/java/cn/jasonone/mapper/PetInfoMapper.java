package cn.jasonone.mapper;

import cn.jasonone.bean.PetInfo;

import java.util.List;

/**
* @author miss
* @description 针对表【pet_info(宠物信息表)】的数据库操作Mapper
* @createDate 2023-04-09 15:26:05
* @Entity cn.jasonone.bean.PetInfo
*/
public interface PetInfoMapper {
    /**
     * 查询所有宠物
     * @return
     */
    List<PetInfo> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(PetInfo record);

    int insertSelective(PetInfo record);

    PetInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PetInfo record);

    int updateByPrimaryKey(PetInfo record);

}
