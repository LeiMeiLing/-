package cn.jasonone.mapper;

import cn.jasonone.bean.GoodsInfo;

import java.util.List;

/**
* @author miss
* @description 针对表【goods_info(商品信息表)】的数据库操作Mapper
* @createDate 2023-04-09 15:55:04
* @Entity cn.jasonone.bean.GoodsInfo
*/
public interface GoodsInfoMapper {
    /**
     * 查询所有商品数据
     */
    List<GoodsInfo> selectAll();

    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    /**
     * 通过id查询商品信息
     * @param id
     * @return
     */
    GoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);


}
