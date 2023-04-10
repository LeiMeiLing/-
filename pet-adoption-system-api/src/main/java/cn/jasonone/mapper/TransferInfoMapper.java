package cn.jasonone.mapper;

import cn.jasonone.bean.TransferInfo;

/**
* @author Mrli
* @description 针对表【transfer_info(转让信息表)】的数据库操作Mapper
* @createDate 2023-04-10 09:59:50
* @Entity cn.jasonone.bean.TransferInfo
*/
public interface TransferInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TransferInfo record);

    int insertSelective(TransferInfo record);

    TransferInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransferInfo record);

    int updateByPrimaryKey(TransferInfo record);

}
