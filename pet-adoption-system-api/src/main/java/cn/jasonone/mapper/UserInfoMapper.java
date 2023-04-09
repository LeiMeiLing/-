package cn.jasonone.mapper;

import cn.jasonone.bean.UserInfo;

/**
* @author DELL
* @description 针对表【user_info(用户信息表)】的数据库操作Mapper
* @createDate 2023-04-08 14:33:13
* @Entity cn.cn.jasonone.bean.UserInfo
*/
public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

}
